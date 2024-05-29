/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example


import groovy.transform.CompileStatic

@CompileStatic
class App {
    String getSysInfo() {
        "Runtime: Groovy ${GroovySystem.getVersion()} on ${System.getProperty('java.vm.name')} ${System.getProperty('java.runtime.version')}"
    }

    void run() {
        println getSysInfo()
        println ListOK.spread([1, 2, 3] as Object[])
        println ListDelegate.spread([1, 2, 3] as Object[])
    }

    static void main(String[] args) {
        new App().run()
    }
}
