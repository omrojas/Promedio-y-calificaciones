import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class AddressBook extends JFrame implements ActionListener {
    private final Color
    veryLightGrey = new Color(240, 240, 240),
    darkBlue = new Color(0, 0, 150),
    backGroundColour = veryLightGrey,
    navigationBarColour = Color.lightGray,
    textColour = darkBlue;
    private static final int
    windowWidth = 450, windowHeight = 470,               
    windowLocationX = 200, windowLocationY = 100;        
    private final int
    panelWidth = 450, panelHeight = 250,                
    leftMargin = 50,                                     
    mainHeadingY = 30,                                 
    detailsY = mainHeadingY+40,                         
    detailsLineSep = 30;                                
    private final Font
    mainHeadingFont = new Font("SansSerif", Font.BOLD, 20),
    detailsFont = new Font("SansSerif", Font.PLAIN, 14);

    /** Botones de navegación. */
    private JButton
    first = new JButton("|<"),         
    previous = new JButton("<"),          
    next = new JButton(">"),              
    last = new JButton(">|");            

    /** Botones de acción */
    private JButton
    addContact = new JButton("Añadir contacto"),  
    deleteContact = new JButton("Eliminar contacto"), 
    deleteAll = new JButton("Eliminar todo");         
   
    private JTextField
    nameField = new JTextField(20),                
    mobileField = new JTextField(12);             

    @SuppressWarnings("serial")
	private JPanel contactDetails = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g); 
                paintScreen(g);        
            }
        };


    public static void main(String[] args) {
        AddressBook contacts = new AddressBook();
        contacts.setSize(windowWidth, windowHeight);
        contacts.setLocation(windowLocationX, windowLocationY);
        contacts.setTitle("Address Book");
        contacts.setUpAddressBook();
        contacts.setUpGUI();
        contacts.setVisible(true);
    }

    private void setUpAddressBook() {
        currentSize = 0;   
        addContact("Omar", "5547859612");
        addContact("Yailen", "9934954324");

        currentContact = 0;
    }

    void setUpGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        window.setBackground(navigationBarColour);

        window.add(new JLabel("Navigation:"));
        window.add(first);
        first.addActionListener(this);
        window.add(previous);
        previous.addActionListener(this);
        window.add(next);
        next.addActionListener(this);
        window.add(last);
        last.addActionListener(this);

        contactDetails.setPreferredSize(new Dimension(panelWidth, panelHeight));
        contactDetails.setBackground(backGroundColour);
        window.add(contactDetails);
        
        JPanel addDelPanel = new JPanel();
        addDelPanel.add(addContact);
        addContact.addActionListener(this);
        addDelPanel.add(deleteContact);
        deleteContact.addActionListener(this);
        addDelPanel.add(deleteAll);
        deleteAll.addActionListener(this);
        window.add(addDelPanel);

        JPanel namePanel = new JPanel();
        namePanel.add(new JLabel("Nombre:"));
        namePanel.add(nameField);
        window.add(namePanel);

        JPanel mobilePanel = new JPanel();
        mobilePanel.add(new JLabel("Teléfono:"));
        mobilePanel.add(mobileField);
        window.add(mobilePanel);

    }

    private void paintScreen(Graphics g) {
        g.setColor(textColour);
        g.setFont(mainHeadingFont);
        g.drawString("Detalles de contacto", leftMargin, mainHeadingY);

        displayCurrentDetails(g);
    } 

    private void displayCurrentDetails(Graphics g) {
        g.setColor(textColour);
        g.setFont(detailsFont);
        if (currentContact == -1)          
            g.drawString("No hay contactos", leftMargin, detailsY);
        else {   
            g.drawString(name[currentContact], leftMargin, detailsY);
            g.drawString("Teléfono: " + mobile[currentContact], leftMargin, detailsY + 2 * detailsLineSep);
        }
    } 

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == first)
            if (currentContact >= 0)
                currentContact = 0;
            else
                currentContact = -1;

        if (e.getSource() == previous && currentContact > 0)
            currentContact--;

        if (e.getSource() == next && currentContact < currentSize - 1)
            currentContact++;

        if (e.getSource() == last)
            currentContact = currentSize - 1;

        if (e.getSource() == addContact)
            doAddContact();

        if (e.getSource() == deleteContact)
            doDeleteContact();

        if (e.getSource() == deleteAll)
            doDeleteAll();
        
        repaint();
    } 
 
    private void doAddContact(){
        String newName = nameField.getText();       nameField.setText("");
        String newMobile = mobileField.getText();   mobileField.setText("");
        if (newName.length() == 0) {
            JOptionPane.showMessageDialog(null, "Ningun nombre introducido");
            return;
        }
        int index = addContact(newName, newMobile); 
        if (index == -1)                  
            JOptionPane.showMessageDialog(null, "Sin espacio para nuevo nombre");
        else
            currentContact = index;       
    } 
    
    private void doDeleteContact() {
        if (currentSize == 0) {
            JOptionPane.showMessageDialog(null, "No hay contactos que eliminar");
            return;
        }
        deleteContact(currentContact);
       
        if (currentContact == currentSize)   
            currentContact--;                 
    } 

  
    private void doDeleteAll() {
        clearContacts();
        currentContact = -1;    
    } 

    /** Capacidad máxima de la base de datos. */
    private final int databaseSize = 10;

    /** Para almacenar teléfono y nombre del Contacto. */
    private String[]
    name = new String[databaseSize],
    mobile = new String[databaseSize];

   
    private int currentSize = 0;

    
    private int currentContact = -1;

   
    private int addContact(String newName, String newMobile) {        
        name[currentSize] = newName;        
        mobile[currentSize] = newMobile;
        currentSize++;                      
        return currentSize-1;               

    }

    private void deleteContact(int index) {
    	if (index > -1)
    	{   
            for (int i = index; i < currentSize; i++)
            {
            	name[i] = name[i+1];       
                mobile[i] = mobile[i+1];
            }
            
            currentSize--;

    	} else return;
    } 

    private void clearContacts() {
     
    	for (int i = 0; i < currentSize; i++) {
    		name[i] = null;         // Add data at first free element in each array
            mobile[i] = null;
            
            currentSize--;
    	}
    } 
} 