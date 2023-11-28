# Stripe Auto Configuration for Stripe Java Library

The `StripeAutoConfiguration` class provides auto-configuration to seamlessly integrate the [Stripe Java library](https://github.com/stripe/stripe-java) into a Spring Boot application. This configuration simplifies the setup of the `StripeClient` bean, allowing you to customize its behavior through application properties.

## Configuration Properties

| Property                           | Type      | Description                                                             |
|------------------------------------|-----------|-------------------------------------------------------------------------|
| `stripe.api-key`                   | String    | **Required.** The Stripe API key used for authentication.               |
| `stripe.client-id`                  | String    | The Stripe client ID, if applicable.                                    |
| `stripe.max-network-retries`        | Integer   | The maximum number of network retries in case of failures. Defaults to 2. |
| `stripe.connect-timeout-in-seconds` | Integer   | The connection timeout in seconds. Defaults to 30 seconds.              |
| `stripe.read-timeout-in-seconds`    | Integer   | The read timeout in seconds. Defaults to 80 seconds.                    |
| `stripe.proxy-credential.username`  | String    | The username for proxy authentication, if applicable.                   |
| `stripe.proxy-credential.password`  | String    | The password for proxy authentication, if applicable.                   |
| `stripe.address.api-base`           | String    | The base URL for the Stripe API, if applicable.                         |
| `stripe.address.connect-base`       | String    | The base URL for the Stripe Connect service, if applicable.             |
| `stripe.address.files-base`         | String    | The base URL for accessing files in Stripe, if applicable.              |

## Example of use
```pom.xml
<dependency>
    <groupId>com.elara</groupId>
    <artifactId>stripe-auto-starter</artifactId>
    <version>${stripe-auto-starter.version}</version>
</dependency>
```
***Note:*** get the last version from maven repository

```application.properties
stripe.api-key=sk_test_your_generated_sk
```

```some class
@RestController
@RequestMapping("demo")
public class DemoController {
    private final StripeClient stripeClient;

    public DemoController(StripeClient stripeClient) {
        this.stripeClient = stripeClient;
    }

    @GetMapping
    public String demo() throws StripeException {
        return stripeClient.accounts().retrieveCurrent().toJson();
    }
}
```

As you can see, StripeClient can be used as a bean. It will be instantiated with the properties passed in the application.properties file