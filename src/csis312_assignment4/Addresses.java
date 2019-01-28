package csis312_assignment4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

/* CSIS 312 Assignment 4
* @Isaac Craig & Nick Romnano
* 
* - I have not discussed the source code in my program with anyone other than my instructor’s approved human sources (i.e. programming partner).
* - I have not used source code obtained from another student, or any other unauthorized source, either modified or unmodified.
* - If any source code or documentation used in my program was obtained from another source, such as a text book or course notes, that has been clearly noted *   with a proper citation in the comments of my program. 
* - I have not knowingly designed this program in such a way as to defeat or interfere with the normal operation of any machine it is graded on or to produce     apparently correct results when in fact it does not.
*
**/
public class Addresses {

    // @XmlElement specifies XML element name for each object in the List
    @XmlElement(name = "address")
    private final List<Address> addresses = new ArrayList<>(); // holds shopping list tiems

    public List<Address> getList() {
        return addresses;
    }
}
