package org.example

import groovy.transform.CompileStatic

/**
 *
 * @author Paolo Di Tommaso <paolo.ditommaso@gmail.com>
 */
@CompileStatic
class ListDelegate implements List {

    private @Delegate List target

    static List spread(Object[] args) {
        final result = new ArrayList(args.size()*2)
        for( int i=0; i<args.size(); i++ ) {
            if( args[i] instanceof ListDelegate ) {
                final list = (List)args[i]
                for( def el : list ) {
                    result.add(el)
                }
            }
            else {
                result.add(args[i])
            }
        }
        return result
    }
}
