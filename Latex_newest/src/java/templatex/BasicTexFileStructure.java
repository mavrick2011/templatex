/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package templatex;

import java.util.List;

/**
 *
 * @author Administrator 
 */
public class BasicTexFileStructure {

    List<BasicTexField> fields_;
    
    public void addTexField(BasicTexField field){
        fields_.add(field);
    }
    
    public List<BasicTexField> getFields(){
        return fields_;
    }
}
