package org.example

/**
 *
 * @author Paolo Di Tommaso <paolo.ditommaso@gmail.com>
 */
class ListOK extends ArrayList {

    static List spread(Object[] args) {
        final result = new ArrayList(args.size()*2)
        for( int i=0; i<args.size(); i++ ) {
            if( args[i] instanceof List ) {
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
