# Spring Boot JSON Logging Demo

[![Buy Me a Coffee](https://www.buymeacoffee.com/assets/img/custom_images/orange_img.png)](https://buymeacoffee.com/rcvaram)

## Overview

This Spring Boot application demonstrates how to implement JSON logging instead of default plain text logging, which is particularly useful for applications sending logs to Datadog or similar log management platforms. The project showcases a practical solution to reduce logging costs and improve log management by:

- Preventing fragmented stack traces
- Maintaining log context
- Improving troubleshooting
- Fixing broken alerts
- Reducing logging costs

## Problem Statement

Default Spring Boot logging:
- Creates multiple log events for a single stack trace
- Breaks context by fragmenting logs
- Makes troubleshooting harder
- Causes alerting failures
- Increases logging costs

## Solution

This project implements JSON logging using Logback's Logstash Logback Encoder, ensuring each log event (including stack traces) is captured in a single, structured log event.

## Features

- JSON-formatted logs
- Structured logging with proper context
- Correlation ID tracking
- Proper stack trace handling
- Optimized for Datadog integration

## Project Structure

```
src/main/java/io/github/rcvaram/mediumlogapp/
├── Customer/                    # Customer domain model and services
│   ├── Customer.java           # Customer entity
│   ├── CustomerController.java # REST controller with Swagger annotations
│   └── CustomerService.java    # Business logic
├── filter/                     # Custom filters
│   └── CorrelationFilter.java  # Adds correlation ID
└── MediumLogAppApplication.java # Main application class
```

## API Endpoints

The application includes the following endpoints:

- `GET /api/customers/{id}` - Retrieve a customer by ID
- `POST /api/customers` - Create a new customer
- `PUT /api/customers/{id}` - Update an existing customer
- `DELETE /api/customers/{id}` - Delete a customer

All endpoints are documented in Swagger UI and include:
- Request/response examples
- Parameter validation
- Error responses
- Response codes

## Setup Instructions

1. Clone the repository:
```bash
git clone https://github.com/rcvaram/medium-log-app.git
cd medium-log-app
```

2. Build the project:
```bash
./gradlew build
```

3. Run the application:
```bash
./gradlew bootRun
```

## Log Format Example

```json
{
  "@timestamp": "2025-05-19T00:33:12.7749354+05:30",
  "@version": "1.0.0",
  "level": "ERROR",
  "level_value": 40000,
  "logger_name": "org.apache.catalina.core.ContainerBase.[Tomcat].[localhost].[/].[dispatcherServlet]",
  "message": "Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed: java.lang.RuntimeException: Invalid Customer Id] with root cause",
  "stack_trace": "java.lang.RuntimeException: Invalid Customer Id\r\n\tat io.github.rcvaram.mediumlogapp.Customer.CustomerService.findCustomer(CustomerService.java:11)\r\n...",
  "thread_name": "http-nio-8080-exec-1"
}
```

## Development Tools

- IntelliJ IDEA with Pretty JSON Log Plugin (recommended for better log readability)
- Java 17+
- Gradle
- Swagger UI for API documentation and testing

## API Documentation

The application includes Swagger UI for API documentation and testing. Once the application is running:

1. Access Swagger UI at: `http://localhost:8080/swagger-ui.html`
2. You can:
    - View API documentation
    - Test endpoints directly from the UI
    - See request/response examples
    - Try out different request parameters

## Contributing

Feel free to submit issues and enhancement requests!

## Contributing

Feel free to submit issues and enhancement requests!

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Author

Created by Sivaram Rasathurai

## Support

If you found this project helpful, consider supporting the author:

[![Buy Me a Coffee](https://www.buymeacoffee.com/assets/img/custom_images/orange_img.png)](https://buymeacoffee.com/rcvaram)