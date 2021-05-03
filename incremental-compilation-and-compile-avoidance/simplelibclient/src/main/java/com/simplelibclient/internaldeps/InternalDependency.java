package com.simplelibclient.internaldeps;

public class InternalDependency implements InternalDependencyIF {
    @Override
    public void runInternalAction() {
        System.out.println("InternalDependency::runInternalAction called");
    }
    @Override
    public void unusedMethod2() {
        System.out.println("unusedMethod");
    }
}
