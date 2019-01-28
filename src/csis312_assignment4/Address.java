/*
 * Shopping Item POJO Class
 */
package csis312_assignment4;

/* CSIS 312 Assignment 4
* @Isaac Craig & Nick Romnano
* 
* - I have not discussed the source code in my program with anyone other than my instructor’s approved human sources (i.e. programming partner).
* - I have not used source code obtained from another student, or any other unauthorized source, either modified or unmodified.
* - If any source code or documentation used in my program was obtained from another source, such as a text book or course notes, that has been clearly noted *   with a proper citation in the comments of my program. 
* - I have not knowingly designed this program in such a way as to defeat or interfere with the normal operation of any machine it is graded on or to produce     apparently correct results when in fact it does not.
*
**/
public class Address {
    private String first, last, birthday, address, state, zip;
    //private int zip;
    
    public Address() {
        this("","","","","","");
    }

    public Address(String first,String last,String birthday,String address, String state, String zip) {
        this.first = first;
        this.last = last;
        this.birthday = birthday;
        this.address = address;
        this.state = state;
        this.zip = zip;
    }

    Address(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
