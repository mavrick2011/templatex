/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dbManagement;

/** 
 *
 * @author Administrator
 */
class BasicTexField {

    private String name_;
    private Integer id_;

    public BasicTexField(String name_) {
        this.name_ = name_;
    }
    

    public void setId(Integer id_) {
        this.id_ = id_;
    }

    public void setName(String name_) {
        this.name_ = name_;
    }




    public Integer getId() {
        return id_;
    }

    public String getName() {
        return name_;
    }



}
