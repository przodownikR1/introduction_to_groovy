package pl.groovy.przodownik.domain

import pl.groovy.przodownik.UserGroovy;
import pl.java.przodownik.domain.User;
import spock.lang.Specification;

/**
 * @author Sławomir Borowiec 
 * Module name : groovy_start
 * Creating time :  22 sty 2014 10:42:56
 
 */
class UserSpock extends Specification {
        User user = new User(firstName:'slawek', lastName:'Borowiec',age:34)
    
        UserGroovy  userGroovy= new UserGroovy(firstName:'slawek', lastName:'Borowiec',age:34)
        
        def "groovy and java users are equivalent"() {
            expect:
            user.firstName == userGroovy.firstName
            user.age == userGroovy.age
        }
        
        def 'groovy users have equals method'() {
            given:
            UserGroovy userGroovyCopy = new UserGroovy(firstName:'slawek', lastName:'Borowiec',age:34)
            UserGroovy userGroovyOther = new UserGroovy(firstName:'slawek', lastName:'Borowiec',age:35)
            
            expect:
            userGroovy == userGroovyCopy
            userGroovyCopy  <=> userGroovyOther
        }
        
        
        def 'Set help test hashCode and equals'() {
            given:
            UserGroovy userGroovy1 = new UserGroovy(firstName:'slawek', lastName:'Borowiec',age:34)
            UserGroovy userGroovy2 = new UserGroovy(firstName:'slawek', lastName:'Borowiec',age:34)
            Set tasks = [userGroovy1, userGroovy2, userGroovy]
       
            expect:
            tasks.size() == 1
        }
}
