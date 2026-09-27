package com.devops;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {

    public static void main(String[] args) throws Exception {

        int port = 8081;

        HttpServer server = HttpServer.create(
                new InetSocketAddress(port), 0
        );

        // Main Dashboard
        server.createContext("/", exchange -> {

            String response =
                    "<html>" +
                    "<head>" +
                    "<title>DevOps CI/CD Dashboard</title>" +
                    "<style>" +
                    "body { font-family: Arial; text-align: center; margin: 40px; }" +
                    ".box { max-width: 700px; margin: auto; padding: 25px; " +
                    "border: 1px solid #ccc; border-radius: 10px; }" +
                    ".success { color: green; font-weight: bold; }" +
                    "table { margin: 20px auto; border-collapse: collapse; width: 90%; }" +
                    "td, th { border: 1px solid #ccc; padding: 10px; }" +
                    "</style>" +
                    "</head>" +

                    "<body>" +

                    "<div class='box'>" +

                    "<h1>DevOps CI/CD Deployment Dashboard</h1>" +

                    "<h2>Java Web Application</h2>" +

                    "<table>" +

                    "<tr><th>Component</th><th>Status</th></tr>" +

                    "<tr><td>Application</td>" +
                    "<td class='success'>Running</td></tr>" +

                    "<tr><td>Version</td>" +
                    "<td>3.0</td></tr>" +

                    "<tr><td>CI/CD</td>" +
                    "<td class='success'>Jenkins</td></tr>" +

                    "<tr><td>Container</td>" +
                    "<td class='success'>Docker</td></tr>" +

                    "<tr><td>Orchestration</td>" +
                    "<td class='success'>Kubernetes</td></tr>" +

                    "<tr><td>Replicas</td>" +
                    "<td>2</td></tr>" +

                    "</table>" +

                    "<h3>Deployment Status</h3>" +

                    "<p class='success'>✓ Application Running</p>" +
                    "<p class='success'>✓ Docker Container Deployed</p>" +
                    "<p class='success'>✓ Kubernetes Pods Running</p>" +

                    "<hr>" +

                    "<p><b>Design and Implementation of an Automated CI/CD Pipeline</b></p>" +
                    "<p>Using Jenkins, Docker and Kubernetes</p>" +
                    "<p>Developed by Sneha Shingade</p>" +

                    "</div>" +

                    "</body>" +
                    "</html>";

            exchange.getResponseHeaders()
                    .set("Content-Type", "text/html");

            exchange.sendResponseHeaders(
                    200, response.getBytes().length
            );

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });

        // Health Check
        server.createContext("/health", exchange -> {

            String response = "Application is healthy";

            exchange.getResponseHeaders()
                    .set("Content-Type", "text/plain");

            exchange.sendResponseHeaders(
                    200, response.getBytes().length
            );

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });

        // Version
        server.createContext("/version", exchange -> {

            String response = "Application Version: 3.0";

            exchange.getResponseHeaders()
                    .set("Content-Type", "text/plain");

            exchange.sendResponseHeaders(
                    200, response.getBytes().length
            );

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });

        server.start();

        System.out.println("DevOps Dashboard running on port " + port);
    }
}
