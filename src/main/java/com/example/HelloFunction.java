package com.example.fn;
import com.fnproject.fn.api.FnConfiguration;
import com.fnproject.fn.api.RuntimeContext;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import com.fnproject.fn.api.httpgateway.HTTPGatewayContext;
import com.fnproject.fn.api.Headers;
import com.fnproject.fn.api.InvocationContext;
import com.fnproject.fn.api.QueryParameters;
import java.util.logging.Logger;

public class HelloFunction {
    /* Vars for Env Variables */
    private String dbHost;		// DB_HOST
    private String dbUser;		// DB_USER
    private String dbPassword;	// DB_PASSWORD
    private static final Logger LOGGER = Logger.getLogger(HelloFunction.class.getName());
    
    @FnConfiguration
    public void config(RuntimeContext ctx) {

        System.out.println(ctx.toString());

        dbHost = ctx.getConfigurationByKey("DB_HOST_URL").orElse("//localhost/DBName");

        dbUser = ctx.getConfigurationByKey("DB_USER").orElse("your-db-account");

        dbPassword = ctx.getConfigurationByKey("DB_PASSWORD").orElse("your-db-password");

    }

   public String handleRequest(String input,HTTPGatewayContext hctx)  {
        String name = (input == null || input.isEmpty()) ? "world"  : input;
        String httpMethod = hctx.getMethod();
        String httpRequestURI = hctx.getRequestURL();
        QueryParameters queryparams = hctx.getQueryParameters();

        LOGGER.info("Inside Java Hello World function"+ queryparams.get("name")); 
        return "Hello, " + name +  "!";
    }
}
