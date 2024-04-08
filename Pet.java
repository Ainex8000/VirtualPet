// Create a QUI virtual pet that can intereacted with by the user.
// Import our libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Create the Pet class
// Note: remember our OOP design principles. We have have a Pet class that will extend JFrame
// The JFrame will be the parent class that we will be using
public class Pet extends JFrame {
    // Now we will create our instance variables
    private int hunger;
    private int happiness;
    private int cleanliness;
    // JLabels will be used to display the current state of the pet
    // State means what are the current values of the pet's hunger, happiness, and cleanliness
    private JLabel petLabel, hungerLabel, happinessLabel, cleanlinessLabel;
    // JButtons will be used to interact with the pet
    private JButton feastButton, conquerButton, cleanButton;

    // Create the constructor for the Pet class
    // The constructor will be used to initialize the values of the pet
    public Pet(){
        // Initialize the values of the pet (hunger, happiness, and cleanliness)
        hunger = 50;
        happiness = 50;
        cleanliness = 50;

        // Create the layout for the GUI, this will set up our GUI components
        // An image that represents the Rat King (the pet)
        petLabel = new JLabel(new ImageIcon("mypet.png"));
        // This will display the current state of the pet (hunger, happiness, cleanliness)
        hungerLabel = new JLabel("Hunger: " + hunger);
        happinessLabel = new JLabel("Happiness: " + happiness);
        cleanlinessLabel = new JLabel("Cleanliness: " + cleanliness);

        // Create the buttons that will be used to interact with the pet (feast, conquer, clean)
        feastButton = new JButton("Feast");
        conquerButton = new JButton("Conquer");
        cleanButton = new JButton("Clean");

        // Now we will do a little event handling
        // We will add an ActionListener to each of the buttons
        // This will allow us to interact with the pet
        feastButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // Now that an event has been raised by the user, we need to handle the event with code
                // Decrease hunger by pet, since the user fed the Rat King (the pet)
                hunger = hunger - 10;
                // Decrease cleanliness as the Rat King (the pet) is a messy eater
                cleanliness = cleanliness - 10;
                // Update the JLabel that displays the current state of the pet
                updateLabels();
            }
        });

        conquerButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // Now that an event has been raised by the user, we need to handle the event with code
                // Increase happiness by pet, since the user played with the Rat King (the pet)
                happiness = happiness + 10;
                // Conquering makes the Rat King dirty, so decrease cleanliness by pet
                cleanliness = cleanliness - 10;
                // Conquering makes the Rat King hungee (the pet get hungry), so decrease hunger by pet
                hunger = hunger + 10;
                // Update the JLabel that displays the current state of the pet
                updateLabels();
            }
        });

        cleanButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // Now that an event has been raised by the user, we need to handle the event with code
                // Increase cleanliness by pet, since the user cleaned the Rat King (the pet)
                cleanliness = cleanliness + 10;
                // Update the JLabel that displays the current state of the pet
                updateLabels();
            }
        });

        // Setup our layout for our GUI
        setLayout(new FlowLayout());
        // Add the components to the GUI
        // Add our pet label, hunger, happiness, and cleanliness labels
        add(petLabel);
        add(hungerLabel);
        add(happinessLabel);
        add(cleanlinessLabel);
        // Add the buttons to the GUI (feast, conquer, clean)
        add(feastButton);
        add(conquerButton);
        add(cleanButton);

        // Finish setting up the GUI by setting the size and visibility
        setSize(500, 500);
        setVisible(true);
    }

    // Update the labels to display the current state of the pet
    private void updateLabels() {
        hungerLabel.setText("Hunger: " + hunger);
        happinessLabel.setText("Happiness: " + happiness);
        cleanlinessLabel.setText("Cleanliness: " + cleanliness);
    }

    // Main method that will be used to run the program
    public static void main(String[] args) {
        // Create a net pet object
        new Pet();
    }
}
