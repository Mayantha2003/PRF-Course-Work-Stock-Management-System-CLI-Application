import java.util.*;

public class Demo{

    static Scanner input =new Scanner(System.in);
    static String[][]supplier = new String[0][2]; // {{"S001","Oshan"},{"S002","Dilni"},{"S003","Viranga"}
    static String[]category=new String[0]; // {"Food" , " Medicin"," gift "}
    static String[][]item=new String[0][6]; // {{"Supplier Id" , "Item Code" , "Description" , "Price" , "qty" , "Category"}}
    static String correctUsername = "Maya";
    static String correctPassword = "1234";


    public static void main(String[] args){

        loginPage();
     }

    //clear Console
    private final static void clearConsole(){

        final String os = System.getProperty("os.name");
        try {
            if (os.equals("Linux")) {
                System.out.print("\033\143");
            } else if (os.equals("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            //handle the exception
            System.err.println(e.getMessage());
        }
    }
  
    //login page
    public static void loginPage(){

       clearConsole();

       System.out.println("+--------------------------------------------------------------------------------------------+");
       System.out.println("|                                     LOGIN PAGE                                             |");
       System.out.println("+--------------------------------------------------------------------------------------------+");

       while (true) {
        System.out.print("\nUser name : ");
        String inputUsername = input.next();
        if(correctUsername.equals(inputUsername)){
            break;
        }
        else{
            System.out.println("User name is invalid.please try again !");
        }
       }

       while (true) {
        System.out.print("\nPassword : ");
        String inputPassword = input.next();
        if(correctPassword.equals(inputPassword)){
            break;
        }
        else{
            System.out.println("Password is invalid.please try again !");
        }
       }
        homePage();
    }
    
    //Home page
    public static void homePage(){

        clearConsole();

        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.println("|                  WELCOME TO IJSE STOCK MANAGEMENT SYSTEM                                   |");
        System.out.println("+--------------------------------------------------------------------------------------------+");

        System.out.println("\n[1] Change the Credentials \t\t[2] Supplier Manage ");
        System.out.println("[3] Stock Mange \t\t\t[4] Log out");
        System.out.println("[5] Exit the System");

        while(true){

            System.out.print("\nEnter an option to continue > ");  
            String option = input.next();

            switch(option){
                case "1":
                    credentialMange();
                    break;
                case "2":
                    supplierManage();
                    break;
                case "3":
                    stockManage();
                    break;
                case "4":
                    loginPage();
                    break;
                case "5":
                    exitTheSystem();
                    break;
                default:
                    System.out.println("Invalid Option! Please choose between 1 - 5.");
                    //loop wil continue again.       
            }
        }
    }
    
    //Credential Mange
    public static void credentialMange(){

        clearConsole();

        System.out.println("+------------------------------------------------------------------------------------+");
        System.out.println("|                           CREDENTIAL MANAGE                                        |");
        System.out.println("+------------------------------------------------------------------------------------+");
                
        while (true) {
            System.out.print("Please enter the user name to verify it's you : ");
            String checkUsername = input.next();
                if(correctUsername.equals(checkUsername)){
                    System.out.println("Hey" + " " + correctUsername);
                    break;
                }else{
                    System.out.println("Invaid username.try again !");
                }
        }

        while (true) {
            System.out.print("Enter your current password :");
            String inputPassword = input.next();
            
            if(inputPassword.equals(correctPassword)){
                System.out.print("Enter you new password : ");
                String newpassword = input.next();

                correctPassword = newpassword;

                while(true){
                    System.out.print("Password changed successfully! Do you want to go home page (Y/ N) :");
                    String select = input.next();

                    if(select.equalsIgnoreCase("y")){
                        clearConsole();
                        homePage();
                        break;
                    }else if(select.equalsIgnoreCase("n")){
                        clearConsole();
                        return;
                    }else{
                        System.out.println("Invalid input! Please enter 'y' or 'n'.");   
                    }
                }
            }
            else{
                System.out.println("Incorrect password.try again ! ");
            }
        }
    }
    
    //Supplier Manage
    public static void supplierManage(){

        clearConsole();
    
        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.println("|                                 SUPPLIER MANGE                                             |");
        System.out.println("+--------------------------------------------------------------------------------------------+");

        System.out.println("\n[1] Add Supplier \t\t [2] Update Supplier ");
        System.out.println("[3] Delete Supplier \t\t [4] View Supplier");
        System.out.println("[5] Search Supplier \t\t [6] Home Page");

        while(true){
            System.out.print("\nEnter option to continue > ");
            String count = input.next();

            switch (count) {
                case "1":
                    addSupplier();
                    break;
                case "2":
                    updatedSupplier();
                    break;
                case "3":
                    deleteSupplier();
                    break;
                case "4":
                    viewSuppliers();
                    break;
                case "5":
                    searchSupplier();
                    break;
                case "6":
                    homePage();
                    break;
                default:
                    System.out.println("Invalid Option! Please choose between 1 - 6.");
                    //loop wil continue again.
            }
        }
    }
  
    // Add Supplier Topic
    public static void addSupplierTopic(){

        System.out.println("+-----------------------------------------------------------------------------------------+");
        System.out.println("|                            ADD SUPPLIER                                                 |");
        System.out.println("+-----------------------------------------------------------------------------------------+");
    }
    
    //Add Supplier
    public static void addSupplier(){

        clearConsole();
        addSupplierTopic();

        while (true) {
            System.out.print("\nSupplier ID : ");
            String supplierID = input.next();

            boolean exists = false;

            for(int i = 0 ; i < supplier.length;i++){
                if (supplier[i][0] != null && supplier[i][0].equals(supplierID)) {  
                    exists = true;
                    break;   
                }
            }  
            if (exists) {
                System.out.println("Already exists. Try another supplier ID!");
                continue;  
            }

            System.out.print("\nSupplier Name : ");
            String supplierName = input.next();
            
            // Increase array size
            String[][] newSupplier = new String[supplier.length + 1][2];

            // Copy existing data
            for (int i = 0; i < supplier.length; i++) {
                newSupplier[i][0] = supplier[i][0];
                newSupplier[i][1] = supplier[i][1];
            }
            // Add new supplier
            newSupplier[supplier.length][0] = supplierID;
            newSupplier[supplier.length][1] = supplierName;

            // Assign the updated array
            supplier = newSupplier;

            while (true) {

                System.out.print("added successfully! Do you want to add another supplier(y/n)?");
                String option = input.next();
                
                if(option.equalsIgnoreCase("y")){
                    clearConsole();
                    addSupplierTopic();
                    break;
                    
                }else if(option.equalsIgnoreCase("n")){
                    clearConsole();
                    supplierManage();
                    return;
                }else{
                    System.out.println("Invalid input! Please enter 'y' or 'n'.");   
                } 
            } 
        }
    }
    
    //Update Supplier Topic
    public static void updateSupplierTopic(){

        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.println("|                                 UPDATE SUPPLIER                                            |");
        System.out.println("+--------------------------------------------------------------------------------------------+");
    }

    //Update Supplier
    public static void updatedSupplier(){

        clearConsole();
        updateSupplierTopic();

        while(true){

            System.out.print("\nSupplier ID : ");
            String checkId = input.next();

            boolean exists = false;

            for(int i = 0 ; i < supplier.length;i++){
                if(supplier[i][0] != null && supplier[i][0].equals(checkId)){

                    //old supplier name
                    System.out.println("Supplier Name : " + supplier[i][1]);

                    //new supplier name
                    System.out.print("\nEnter the new Supplier Name : ");
                    String newSupplierName = input.next();

                    //add newsupplier name old array
                    supplier[i][1] = newSupplierName;

                    exists =true;
                    break;
                } 
            } 
            //Not find the id
            if(!exists){
                System.out.println("Can't find supplier id. try again ! ");
                continue; // back to top of loop
            }

            while (true) {

                System.out.print("Updated Successfully! Do you want to update another supplier?(Y/N) ");
                String option = input.next();
                
                if(option.equalsIgnoreCase("y")){
                    clearConsole();
                    updateSupplierTopic();
                    break;
                }
                else if(option.equalsIgnoreCase("n")){
                    clearConsole();
                    supplierManage();//Back to supplier manager
                    return;
                }else{
                    System.out.println("Invalid input! Please enter 'y' or 'n'.");
                }   
            }
            
        } 
    }

    //Delete Supplier topic
    public static void deleteSupplierTopic(){

        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.println("|                                 DELETE SUPPLIER                                            |");
        System.out.println("+--------------------------------------------------------------------------------------------+");
    }
    
    //Delete Supplier
    public static void deleteSupplier(){

        clearConsole();
        deleteSupplierTopic();

        while (true) {
            System.out.print("\nSupplier ID : ");
            String deletSupplierId = input.next();

            boolean exists = false ;
            for(int i = 0 ; i < supplier.length ; i++){
                if(supplier[i][0] != null && supplier[i][0].equals(deletSupplierId)){

                    supplier[i][0] = null; //Null to Array
                    supplier[i][1] = null; //Null to Array
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                System.out.println("can't find supplier id.try agin!");
                continue;
            }

            while (true) {
                System.out.print("deleted successfully! Do you want to delete another?(Y/N) ");
                String option = input.next();
                
                if(option.equalsIgnoreCase("y")){
                    clearConsole();
                    deleteSupplierTopic();
                    break;
                }else if(option.equalsIgnoreCase("n")){
                    clearConsole();
                    supplierManage();
                    return;
                }else{
                    System.out.println("Invalid input. Please enter Y or N.");
                }     
            }
        }
    }
    
    //View Supplier
    public static void viewSuppliers(){

        clearConsole();

        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.println("|                                 VIEW SUPPLIERS                                             |");
        System.out.println("+--------------------------------------------------------------------------------------------+");

        System.out.printf("%n");
        System.out.printf("+---------------------+--------------------------+%n");
        System.out.printf("| %-20s| %-25s| %n","SUPPLIER ID","SUPPLIER NAME");
        System.out.printf("+---------------------+--------------------------+%n");

        boolean empty = true;

        for(int i = 0 ; i < supplier.length;i++){
            if(supplier[i][0] != null){ //Check Empty Array
                System.out.printf("| %-20s| %-25s| %n", supplier[i][0],supplier[i][1]);
                empty = false;
            }
        }  
        if(empty){
            System.out.printf("| %-47s| %n","No suppliers available.");
        }
            
        System.out.printf("+---------------------+--------------------------+%n");
        System.out.printf("%n");

        while (true) {

            System.out.print("Do you want to go supplier mange page(Y/N)? ");
            String option = input.next();

            if(option.equalsIgnoreCase("y")){
                clearConsole();
                supplierManage();
                break;
            }else if(option.equalsIgnoreCase("n")){
                clearConsole();
                return;
            }else{
                System.out.println("Invalid input. Please enter Y or N.");  
            }
        }       
    }

    //Search Supplier Topic
    public static void searchSupplierTopic(){

        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.println("|                                SEARCH SUPPLIER                                             |");
        System.out.println("+--------------------------------------------------------------------------------------------+");
    }

    //Search Supplier
    public static void searchSupplier(){

        clearConsole();
        searchSupplierTopic();

        while (true) {

            System.out.print("\nSupplier ID : ");
            String serchId = input.next();

            boolean exists = false;

            for(int i = 0; i < supplier.length; i++){
                if(supplier[i][0] != null && supplier[i][0].equals(serchId)){
                    System.out.println("Supplier Name :" + supplier[i][1]);
                    exists = true;
                    break;
                }
            }

            if(!exists){
                System.out.println("can't find supplier id. try again!");
                continue;
            }
            while (true) {

                System.out.print("added successfully! Do you want to add another find(Y/N)? ");
                String option =input.next();

                if(option.equalsIgnoreCase("y")){
                    clearConsole();
                    searchSupplierTopic();
                    break;
                }
                else if(option.equalsIgnoreCase("n")){
                   clearConsole();
                   supplierManage();
                   return;
                } 
                else{
                    System.out.println("Invalid input. Please enter Y or N.");  
                } 
            }  
        }
    }
    
    //Stock Manage
    public static void stockManage(){

        clearConsole();

        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.println("|                               STOCK MANAGEMENT                                             |");
        System.out.println("+--------------------------------------------------------------------------------------------+");

        System.out.println("\n[1] Manage Item Categories \t\t [2] Add Item ");
        System.out.println("[3] Get Items Supplier Wise \t\t [4] View Items");
        System.out.println("[5] Rank Items Per Unit Price \t\t [6] Home Page");

        while(true){
            System.out.print("\nEnter option to continue > ");
            String count = input.next();

            switch (count) {
                case "1":
                    manageItemCategories();
                    break;
                case "2":
                    addItem();
                    break;
                case "3":
                    getItemSupplierwise();
                    break;
                case "4":
                    viewItems();
                    break;
                case "5":
                    rankItemsPerUnitPrice();
                    break;
                case "6":
                    homePage();
                    break;
                default:
                    System.out.println("Invalid Option! Please choose between 1 - 6.");
            }
        }
    }
    
    //Manage Item Categories
    public static void manageItemCategories(){

        clearConsole();

        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.println("|                              MANAGE ITEM CATEGORY                                          |");
        System.out.println("+--------------------------------------------------------------------------------------------+");

        System.out.println("\n[1] Add New Item Category \t\t [2] Delete Item Category ");
        System.out.println("[3] Update Item Category \t\t [4] Stock Management");

        while (true) {
            System.out.print("\nEnter option to continue > ");
            String count = input.next();

            switch (count) {
                case "1":
                    addNewItemCategory();
                    break;
                case "2":
                    deleteItemCategory();
                    break;
                case "3":
                    updateItemCategory();
                    break;
                case "4":
                    stockManage();
                    break;
                default:
                    System.out.println("Invalid Option! Please choose between 1 - 4.");
                }   
        }
    }

    //Add New Item Category Topic
    public static void addNewItemCategoryTopic(){

        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.println("|                              ADD ITEM CATEGORY                                             |");
        System.out.println("+--------------------------------------------------------------------------------------------+");
    }
    
    //Add New Item Category
    public static void addNewItemCategory(){

        clearConsole();
        addNewItemCategoryTopic();

        while(true){
            System.out.print("\nEnter the new item category : ");
            String addItem = input.next();

            boolean exists = false;

            for(int i = 0 ; i < category.length; i++){
                if(category[i] != null && category[i].equals(addItem)){
                    exists = true ;
                    break;
                }
            }
            if(exists){
                System.out.println("Already exists. Try another Catogory!");
                continue;
            }
            
            String [] newcategory = Arrays.copyOf(category,category.length +  1);
            
            newcategory[newcategory.length - 1]= addItem;
            
            category = newcategory;

            while (true) {

                System.out.print("added successfully! Do you want to add another category(Y/N)?");
                String option = input.next();

                if(option.equalsIgnoreCase("y")){
                    clearConsole();
                    addNewItemCategoryTopic();
                    break;   
                }
                else if(option.equalsIgnoreCase("n")){
                    clearConsole();
                    stockManage();
                    return;
                }
                else{
                      System.out.println("Invalid input! Please enter 'y' or 'n'."); 
                }  
            }   
        
        }
    }

    //Delete Item Category Topic
    public static void deleteItemCategoryTopic(){

        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.println("|                           DELETE ITEM CATEGORY                                             |");
        System.out.println("+--------------------------------------------------------------------------------------------+");
    }
    
    //Delete Item Category
    public static void deleteItemCategory(){

        clearConsole();
        deleteItemCategoryTopic();

        while (true) {

            System.out.print("\nEnter the delete item category : ");
            String deleteCategory = input.next();

            boolean exists = false;

            for(int i = 0 ; i < category.length; i++){
                if(category[i] != null && category[i].equalsIgnoreCase(deleteCategory)){

                    category[i] = null;
                    exists =true;
                    break;
                }
            }
            if(!exists){
                System.out.println("Can't find item catogory. try agin! ");
                continue;
            }
            while (true) {

                System.out.print("deleted successfully! Do you want to delete another?(Y/N) ");
                String option = input.next();

                if(option.equalsIgnoreCase("y")){
                    clearConsole();
                    deleteItemCategoryTopic();
                    break;   
                }
                else if(option.equalsIgnoreCase("n")){
                    clearConsole();
                    stockManage();
                    return;
                }
                else{
                      System.out.println("Invalid input! Please enter 'y' or 'n'."); 
                }     
            }  
        }
    }

    //Update Item Category Topic
    public static void updateItemCategoryTopic(){

        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.println("|                           UPDATE ITEM CATEGORY                                             |");
        System.out.println("+--------------------------------------------------------------------------------------------+");

    }

    //Update Item Catagory
    public static void updateItemCategory(){

        clearConsole();
        updateItemCategoryTopic();

        while (true) {
            System.out.print("\nEnter the category name : ");
            String checkCategoryName = input.next();

            boolean exists = false;
            for(int i = 0 ; i < category.length; i++){
                if(category[i] != null && category[i].equalsIgnoreCase(checkCategoryName)){

                    System.out.print("\nEnter the new category name : ");
                    String newItemCategory = input.next();

                    category[i] = newItemCategory;

                    exists = true;
                    break;
                }
            }
            if(!exists){
                System.out.print("Can't find category name. try again ! ");
                return;
            }

            while (true) {

                System.out.print("Updated Successfully! Do you want to update another item category?(Y/N) ");
                String option = input.next();
                
                if(option.equalsIgnoreCase("y")){
                    clearConsole();
                    updateItemCategoryTopic();
                    break;
                }
                else if(option.equalsIgnoreCase("n")){
                    clearConsole();
                    stockManage();
                    return;
                }else{
                    System.out.println("Invalid input! Please enter 'y' or 'n'.");   
                }  
            }   
        }
    }

    //Add Item Topic
    public static void additemtopic(){

        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.println("|                                     ADD ITEM                                               |");
        System.out.println("+--------------------------------------------------------------------------------------------+");
    }
    
    //Add Item
    public static void addItem(){
       
        clearConsole();
        additemtopic();

        while(true){
            //Check the null in Category array
            if(category.length == 0) {
                System.out.print("OOPS! It seems that you don't have any item categories in the system.\nDo you want to add a new item category?(Y/N)");
                String option = input.next();
                if(option.equalsIgnoreCase("y")){
                    clearConsole();
                    addNewItemCategory();
                }else{
                    return;
                }
            }
            //Check the null in Supplier array
            if(supplier.length == 0){
                System.out.print("OOPS! It seems that you don't have any suppliers in the system.\nDo you want to add a new supplier?(Y/N)");
                String option = input.next();
                if(option.equalsIgnoreCase("y")){
                    clearConsole();
                    addSupplier();
                }else{
                    return;
                }
            }

            System.out.print("\nItem code : ");
            String inputItemCode = input.next();

            boolean exites = false;

            for(int i = 0; i < item.length; i++){
                if(item[i][1].equals(inputItemCode)){
                     exites =true;
                     break;
                }   
            }

            if(exites){
                System.out.println("Item code already exists! Try again.");
                continue;
            }

            System.out.println("\nSupplier list:");
            System.out.printf("+-----------------+--------------------+--------------------+%n");
            System.out.printf("| %-15s | %-18s | %-18s | %n", "#","SUPPLIER ID","SUPPLIER NAME");
            System.out.printf("+-----------------+--------------------+--------------------+%n");

            for(int i = 0 ; i < supplier.length ; i++){
                if(supplier[i][0] != null){
                    System.out.printf("| %-15d | %-18s | %-18s |%n", i+1 , supplier[i][0] , supplier[i][1]);   
                }  
            }
            System.out.printf("+-----------------+--------------------+--------------------+%n");


            System.out.print("\nEnter the supplier number > ");
            int itemSupplier = input.nextInt() - 1 ; // Enter number - 1 ( 2 - 1)

                if (itemSupplier < 0 || itemSupplier >= supplier.length) {
                    System.out.println("Invalid supplier number! Try again.");
                    continue;
                }

            String addSupplierId = supplier[itemSupplier][0]; // Assign to variable enter number - 1(Array index)


            System.out.println("\nItem Categories :");
            System.out.printf("+-----------------+-----------------------+%n");
            System.out.printf("| %-15s | %-21s | %n", "#","CATEGORY NAME");
            System.out.printf("+-----------------+-----------------------+%n");


            for(int i = 0 ; i < category.length ; i++){
                if(category[i] != null){
                    System.out.printf("| %-15s | %-21s | %n", i+1 , category[i]); 
                }  
            }
            System.out.printf("+-----------------+-----------------------+%n");

            System.out.print("\nEnter the category number > ");
            int itemCategoryName = input.nextInt() - 1 ;

                if (itemCategoryName < 0 || itemCategoryName >= category.length) {
                    System.out.println("Invalid category number! Try again.");
                    continue;
                }

            String addCategoryName = category[itemCategoryName];
 
            System.out.print("\nDescription : ");
            String description = input.next();
            
            System.out.print("Unit price : ");
            String unitPrice = input.next();

            System.out.print("Qty on hand : ");
            String qty = input.next();

            // Now expand the items array
            String[][] newItem = new String[item.length + 1][6];
            for(int i = 0 ; i < item.length ; i++){
                newItem[i] = item[i];
            }
            //Add new item at the last index
            newItem[item.length][0] = addSupplierId;
            newItem[item.length][1] = inputItemCode;
            newItem[item.length][2] = description;
            newItem[item.length][3] = unitPrice;
            newItem[item.length][4] = qty;
            newItem[item.length][5] = addCategoryName;

            //Replace old items array with new one
            item = newItem ;

            while(true){

                System.out.print("added successfully! Do you want to add another Item(Y/N) ");
                String option = input.next();

                if(option.equalsIgnoreCase("y")){
                    clearConsole();
                    additemtopic();
                    break;
                }else if(option.equalsIgnoreCase("n")){
                    clearConsole();
                    stockManage();
                    return;
                }else{
                    System.out.println("Invalid input! Please enter 'y' or 'n'.");   
                }  
            }  
        }
    }

    //Get Item Supplier wise Topic
    public static void getItemSupplierwiseTopic(){

        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.println("|                           SEARCH ITEMS SUPPLIER WISE                                       |");
        System.out.println("+--------------------------------------------------------------------------------------------+");
    }

    //Get Items Supplier Wise
    public static void getItemSupplierwise(){

        clearConsole();
        getItemSupplierwiseTopic();

        while(true){

            System.out.print("\nEnter Supplier Id : ");
            String itemSupplier = input.next();

            boolean exists = false;
            for(int i = 0 ; i < supplier.length ; i++){
                if(supplier[i][0] != null && supplier[i][0].equals(itemSupplier)){
                    System.out.println("Supplier Name : " + supplier[i][1]);

                    System.out.printf("+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
                    System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s |%n","ITEM CODE", "DESCRIPTION", "UNIT PRICE", "QTY ON HAND", "CATEGOEY");
                    System.out.printf("+-----------------+-----------------+-----------------+-----------------+-----------------+%n");

                    for(int j = 0 ; j < item.length ; j++){
                        if(item[j][0] != null && item[j][0].equals(itemSupplier)){
                            System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s |%n", item[j][1] , item[j][2] , item[j][3] , item[j][4] , item[j][5]);
                            exists = true;
                        }
                    }  
                    
                    System.out.printf("+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
                    break;
                }
            }

            if(!exists){
                System.out.println("Can't find supplier id or no items under this supplier. try again ! ");
            }

            while(true){

                System.out.print("search successfully! Do you want to another search?(Y/N) ");
                String option = input.next();

                 if(option.equalsIgnoreCase("y")){
                    clearConsole();
                    getItemSupplierwiseTopic();
                    break;
                }else if(option.equalsIgnoreCase("n")){
                    clearConsole();
                    stockManage();
                    return;
                }else{
                    System.out.println("Invalid input! Please enter 'y' or 'n'.");   
                }
            }  
        }
    }

    //View Items
    public static void viewItems(){

        clearConsole();

        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.println("|                                      VIEW ITEMS                                            |");
        System.out.println("+--------------------------------------------------------------------------------------------+");
        
        boolean exists = false;

        for(int i = 0 ; i < category.length ; i++ ){
            if(category[i] != null){ 
                System.out.println("\n" + category[i] + ":");
                
                System.out.printf("+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
                System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s |%n","SID", "CODE", "DESC", "PRICE", "QTY");
                System.out.printf("+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
                
                boolean categoryHasItems = false;    

                for(int j = 0 ; j < item.length ; j++){
                    if(item[j][0] != null && item[j][5] != null && item[j][5].equals(category[i])){
                        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s |%n", item[j][0] , item[j][1] , item[j][2] , item[j][3] , item[j][4]);
                        exists = true;
                        categoryHasItems = true;
                    }
                }
                if(!categoryHasItems){
                    System.out.printf("| %-88s| %n","No items under this category.");
                }
                System.out.printf("+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
            }
        }
        if(!exists){
            System.out.print("No categories or items found !");   
        }
        while (true) {
            
            System.out.print("\nDo you want to go to the stock manage page?(Y/N): ");
            String option = input.next();

            if(option.equalsIgnoreCase("y")){
                clearConsole();
                stockManage();
                break;
            }
            else if(option.equalsIgnoreCase("n")){
                clearConsole();
                return;
            }
            else{
                 System.out.println("Invalid input! Please enter 'y' or 'n'.");   
            }   
        }   
    }

    //Rank Items Per Unit Price
    public static void rankItemsPerUnitPrice(){

        clearConsole();

        System.out.println("+--------------------------------------------------------------------------------------------+");
        System.out.println("|                                  RANKED UNIT PRICE                                         |");
        System.out.println("+--------------------------------------------------------------------------------------------+");

        for(int i = 0 ; i < item.length - 1 ; i++){
            for(int j = 0 ; j < item.length - i - 1 ; j++){

                double price1 = Double.parseDouble(item[j][3]);
                double price2 = Double.parseDouble(item[j+1][3]);

                if (price1 > price2){
                    
                    String[] temp = item[j];
                    item[j] = item[j + 1];
                    item[j+1] = temp;
                }
            }
        }

        System.out.printf("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n","SID", "CODE", "DESC", "PRICE", "QTY", "CAT");
        System.out.printf("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");

        boolean exists = false;

        for(int i = 0 ; i < item.length ; i++){
            if(item[i][0] != null){ 
                System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n", item[i][0] , item[i][1] , item[i][2] , item[i][3] , item[i][4] , item[i][5]);
                exists  = true;
            }
        }
        System.out.printf("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");

        if(!exists){
            System.out.println("can't find the item . try again !");   
        }
        
        while(true){
            
            System.out.print("Do you want to go stock manage page(Y/N) ");
            String option = input.next();
            
            if(option.equalsIgnoreCase("y")){
                clearConsole();
                stockManage();
                break;

            }else if(option.equalsIgnoreCase("n")){
                clearConsole();
                rankItemsPerUnitPrice();
                return;

            }else{
                System.out.println("Invalid input! Please enter 'y' or 'n'.");
            }
        }
    }

    //Exit The System
    public static void exitTheSystem(){

        clearConsole();

        System.out.println("---------------------");
        System.out.println("(Program exited with code: 0)");
        System.out.println("Press return to continue");
        input.nextLine(); // clear previous input
        input.nextLine(); // wait for ENTER
        input.close();
        System.exit(0);
    }
}