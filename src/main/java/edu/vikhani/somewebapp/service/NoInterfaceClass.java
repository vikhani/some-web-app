package edu.vikhani.somewebapp.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NoInterfaceClass {
    public void doSomething() {
        log.debug("Doing something");
    }

    public void doesNothingSomething() {
    }
}