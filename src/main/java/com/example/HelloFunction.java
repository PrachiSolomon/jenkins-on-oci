package com.example.fn;
import com.fnproject.fn.api.FnConfiguration;
import com.fnproject.fn.api.RuntimeContext;

public class HelloFunction {
    /* Vars for Env Variables */
    private String dbHost;		// DB_HOST
    private String dbUser;		// DB_USER
    private String dbPassword;	// DB_PASSWORD
    
    @FnConfiguration
    public void config(RuntimeContext ctx) {

        System.out.println(ctx.toString());

        dbHost = ctx.getConfigurationByKey("DB_HOST_URL").orElse("//localhost/DBName");

        dbUser = ctx.getConfigurationByKey("DB_USER").orElse("your-db-account");

        dbPassword = ctx.getConfigurationByKey("DB_PASSWORD").orElse("your-db-password");

    }

    public String handleRequest(String input) {
        String name = (input == null || input.isEmpty()) ? "world"  : input;

        System.out.println("Inside Java Hello World function"); 
        return "Hello, " + name + "!";
    }

}
