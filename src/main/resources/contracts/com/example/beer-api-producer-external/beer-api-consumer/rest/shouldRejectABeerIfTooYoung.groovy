// rest/shouldRejectABeerIfTooYoung.groovy
org.springframework.cloud.contract.spec.Contract.make {
    description("""
Represents a successful scenario of getting a beer

```
given:
	client is old enough
when:
	he applies for a beer
then:
	we'll grant him the beer
```

""")
    request {
        method 'POST'
        url '/check'
        body(
                age: $(regex('[0-1][0-9]'))
        )
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body("""
			{
				"status": "NOT_OK"
			}
			""")
        headers {
            contentType(applicationJson())
        }
    }
}