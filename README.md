springboot

Config-server that will read from https://github.com/Yayan89/springboot-config-files


FilterRegistrationBean
Cors


jackson important
Resttemplate important
Mapstruct important

resttemplate with UriComponentsBuilder(params) + fromthttpURL methods

   return restTemplate.exchange(builder.toUriString(),
                HttpMethod.GET,
                new HttpEntity<>(headers),
                AccountSearch.class)
                .getBody();
				
				
	
	Json Deseralize with builder
	remove getter and setters
	
	  @JsonPOJOBuilder(withPrefix = "")
  public static final class ComptePortefeuilleBuilder {
  }
	
	superbuilder lombok
