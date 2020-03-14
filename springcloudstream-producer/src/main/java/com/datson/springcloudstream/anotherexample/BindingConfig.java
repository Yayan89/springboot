package com.datson.springcloudstream.anotherexample;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(value = CalculProcessor.class)
public class BindingConfig {

}
