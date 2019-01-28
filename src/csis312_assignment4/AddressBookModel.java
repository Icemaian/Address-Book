package csis312_assignment4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.JAXB;

/* CSIS 312 Assignment 4
* @Isaac Craig & Nick Romnano
* 
* - I have not discussed the source code in my program with anyone other than my instructor’s approved human sources (i.e. programming partner).
* - I have not used source code obtained from another student, or any other unauthorized source, either modified or unmodified.
* - If any source code or documentation used in my program was obtained from another source, such as a text book or course notes, that has been clearly noted *   with a proper citation in the comments of my program. 
* - I have not knowingly designed this program in such a way as to defeat or interfere with the normal operation of any machine it is graded on or to produce     apparently correct results when in fact it does not.
*
**/
public class AddressBookModel {

    Addresses addressBook;
    static final String location = "src/csis312_assignment4/mylist.xml";

    public AddressBookModel() {
        addressBook = new Addresses();
    }
    
    public List<Address> getItems()
    {
        return addressBook.getList();
    }

    public void loadList() {
        // test if file is present
        if (Files.exists(Paths.get(location))) {

            // try to open file for deserialization
            try (BufferedReader input
                    = Files.newBufferedReader(Paths.get("src/csis312_assignment4/mylist.xml"))) {
                // unmarshal the file's contents
                addressBook = JAXB.unmarshal(input, Addresses.class);

            } catch (IOException ioException) {
                System.err.println("Error opening file.");
            }
        }
    }
    
    

    /**
     * Looks for a matching Address description (ignoring case) and removes from list
     * if found.
     * @param Address 
     */
    public void removeAddress(Address Address) {
        Iterator<Address> iterator = addressBook.getList().iterator();
        boolean found = false;
        while (iterator.hasNext())
        {
            if (iterator.next().getAddress().toLowerCase().equals(Address.getAddress().toLowerCase()))
            {
                iterator.remove();
                found = true;
                break;
            }
        }  
        if (found)
            updateList();
    }

    /**
     * Writes the Shopping List contents to XML file
     */
    public void updateList() {
        try (BufferedWriter output
                = Files.newBufferedWriter(Paths.get(location))) {
            // Write the Shopping List to XML file
            JAXB.marshal(addressBook, output);
        } catch (IOException ioException) {
            System.err.println("Error opening file.");
        }
    }

    /**
     * If Address passed in matches an existing Address, the contents are updated, else
     * a new Address is added.
     * @param Address 
     */
    public void addAddress(Address Address) {
        if (Address.getAddress().length() > 0)
        {
            Iterator<Address> iterator = addressBook.getList().iterator();
            boolean found = false;
            while (iterator.hasNext())
            {
                Address currentAddress = iterator.next();
                if (currentAddress.getAddress().toLowerCase().equals(Address.getAddress().toLowerCase()))
                {   // found matching Address in the list, update
                    currentAddress.setFirst(Address.getFirst());
                    currentAddress.setLast(Address.getLast());
                    currentAddress.setBirthday(Address.getBirthday());
                    currentAddress.setAddress(Address.getAddress());
                    currentAddress.setState(Address.getState());
                    currentAddress.setZip(Address.getZip());
                    found = true;   
                    break;
                }
            }  
            if (!found) // if existing Address not modified, add it
                addressBook.getList().add(Address);
            updateList();   // persist new list to file system
        }
    }
    
    /**
     * Looks for matching shopping list Addresses and returns a list of whats found
     * @param i Address to look for
     * @return list of matching Addresses
     */
    public List<Address> findFirstLast(Address i)
    {
        List<Address> addresses = addressBook.getList();
        List<Address> matched = new ArrayList<>();
        
        if (i.getLast().length() > 0)
        {   
            for (Address Address : addresses)
            {
                if (Address.getLast().toLowerCase().contains(i.getLast().toLowerCase()))
                {
                    matched.add(Address);
                }
            }
        }
        return matched;    
        
    }

}
