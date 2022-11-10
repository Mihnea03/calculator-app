import Plan.*;
import Policy.Customer;
import Policy.Policy;
import Policy.Vehicle;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

public class MainScreen extends JFrame {
    Font myFont = new Font("SansSerif",Font.BOLD,26);
    Color myColor = Color.GRAY;

    public MainScreen(){
        CustomizeCustomerPanel();
        CustomizeVehiclePanel();
        CustomizePlanPanel();
        CustomizeValidityPanel();
        CustomizeActionsPanel();
        CustomizeCoveredRisksPanel();
        CustomizePolicyPanel();
        CustomizeCustomerDataPanel();
        CustomizeClaimPanel();
        CustomizeClaimStatusPanel();
        CustomizePaymentPanel();
        CustomizeSettlementPanel();
    }

    JLabel spacer = new JLabel("             ");

    //Customer Panel
    JTextField fNameSub;
    JTextField lNameSub;
    JTextField citySub;
    JTextField phoneSub;

    //Vehicle Panel
    JTextField platenrSub;
    JTextField modelYearSub;
    JTextField estimatedValueSub;
    JComboBox manufacturerName;
    ButtonGroup Buttons1;
    JRadioButton motorButton;
    JRadioButton bodyButton;
    JRadioButton wheelButton;
    JRadioButton noneButton;

    //Plan Panel
    JCheckBox obligatoryBox;
    JCheckBox allRiskBox;
    JCheckBox vehicleDmgBox;
    JCheckBox driverDmgBox;
    JCheckBox assistanceBox;
    List<String> coveredRisksList = new ArrayList<>();
    List<Float> premiumRisksList = new ArrayList<>();
    List<Float> coverageRisksList = new ArrayList<>();
    List<Float> ceilingRisksList = new ArrayList<>();


    //Validity Panel
    JLabel todayL;
    ButtonGroup Buttons2;
    JRadioButton oneYear;
    JRadioButton twoYears;
    JRadioButton threeYears;
    SimpleDateFormat df;
    Date currentDate;
    int validityYear=0;

    //Actions Panel
    JButton showBTN;
    JButton saveBTN;
    JButton newBTN;
    JTextField enterMobileNr;
    JButton loadBTN;
    JButton deleteBTN;

    //Covered Risks Panel
    JTextArea risks;

    //Policy Details Panel
    JTextArea policyDetails;

    //Customer Data Panel
    JTextArea customerDetails;

    //Claims Panel
    JTextField customerNumber;
    JButton searchCustomer;
    JButton confirmClaim;

    //Claim Status Panel
    JLabel claimingCustomerName;
    JLabel claimingCustomerStatus;
    JLabel claimingCustomerPolicyValidity;
    JTextArea claimingCustomerRisksCovered;
    boolean cond1,cond2,cond3;

    //Payments Panel
    JTextArea paymentArea;
    float totalPremium = 0f;
    float totalCoverage = 0f;
    float totalCeiling = 0f;

    //SettlementPanel
    JTextArea settlementArea;
    JButton resetAll;

    private void CustomizeCustomerPanel(){
        JPanel CustomerPanel = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,2),
                "Customer",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor);
        CustomerPanel.setBorder(titledBorder);

        JLabel fNameL = new JLabel("First Name: ");
        JLabel lNameL = new JLabel("Last Name: ");
        JLabel cityL = new JLabel("City: ");
        JLabel phoneL = new JLabel("Phone Number: ");

        fNameSub = new JTextField(); fNameSub.setOpaque(false);
        lNameSub = new JTextField(); lNameSub.setOpaque(false);
        citySub = new JTextField(); citySub.setOpaque(false);
        phoneSub = new JTextField(); phoneSub.setOpaque(false);

        CustomerPanel.add(fNameL);
        CustomerPanel.add(fNameSub);
        CustomerPanel.add(lNameL);
        CustomerPanel.add(lNameSub);
        CustomerPanel.add(cityL);
        CustomerPanel.add(citySub);
        CustomerPanel.add(phoneL);
        CustomerPanel.add(phoneSub);

        CustomerPanel.setBounds(15,15,300,200);
        CustomerPanel.setLayout(new GridLayout(4,2));

        setLayout(null);
        add(CustomerPanel);
    }

    private void CustomizeVehiclePanel(){
        String[] manufacturers = {
                "Acura", "Alfa Romeo","Audi", "BMW", "Bentley","Buick" , "Cadillac" , "Chevrolet" ,
                "Chrysler" , "Dodge" , "Fiat" , "Ford" , "GMC" , "Genesis" , "Honda" , "Hyundai" ,
                "Infiniti" , "Jaguar" , "Jeep" , "KIA" , "Land Rover" , "Lexus" , "Lincoln" , "Lotus" ,
                "Maserati" , "Mazda" , "Mercedes-Benz" , "Mini Cooper" , "Mitsubishi" , "Nissan" , "Polestar" ,
                "Pontiac" , "Porsche" , "Ram" , "Rivian" , "Rolls-Royce" , "Saab" , "Smart" , "Subaru" ,
                "Suzuki", "Tesla", "Toyota", "Volkswagen", "Volvo"
        };

        JPanel VehiclePanel = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,2),
                "Vehicle",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor);
        VehiclePanel.setBorder(titledBorder);

        JLabel platenrL = new JLabel("Plate Number: ");
        JLabel modelYearL = new JLabel("Model Year: ");
        JLabel manufacturerL = new JLabel("Manufacturer: ");
        JLabel estimatedValueL = new JLabel("Estimated Value: ");
        JLabel damageL = new JLabel("Major Damage: ");

        platenrSub = new JTextField();   platenrSub.setOpaque(false);
        modelYearSub = new JTextField(); modelYearSub.setOpaque(false);
        estimatedValueSub = new JTextField(); estimatedValueSub.setOpaque(false);

        manufacturerName = new JComboBox(manufacturers);

        JPanel space = new JPanel();

        motorButton = new JRadioButton();
        motorButton.setText("Motor");
        bodyButton = new JRadioButton();
        bodyButton.setText("Body");
        wheelButton = new JRadioButton();
        wheelButton.setText("Wheel");
        noneButton = new JRadioButton();
        noneButton.setText("None");
        Buttons1 = new ButtonGroup();
        Buttons1.add(motorButton);
        Buttons1.add(bodyButton);
        Buttons1.add(wheelButton);
        Buttons1.add(noneButton);

        VehiclePanel.add(platenrL);
        VehiclePanel.add(platenrSub);
        VehiclePanel.add(modelYearL);
        VehiclePanel.add(modelYearSub);
        VehiclePanel.add(manufacturerL);
        VehiclePanel.add(manufacturerName);
        VehiclePanel.add(estimatedValueL);
        VehiclePanel.add(estimatedValueSub);
        VehiclePanel.add(space);
        VehiclePanel.add(damageL);
        VehiclePanel.add(motorButton);
        VehiclePanel.add(bodyButton);
        VehiclePanel.add(wheelButton);
        VehiclePanel.add(noneButton);

        VehiclePanel.setBounds(15,225,300,500);
        VehiclePanel.setLayout(new GridLayout(14,1));
        add(VehiclePanel);
    }

    private void CustomizePlanPanel(){
        JPanel PlanPanel = new JPanel();

        TitledBorder titledBorder= BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,2),
                "Plan",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor
        );
        PlanPanel.setBorder(titledBorder);

        JLabel selectLabel = new JLabel("Please Select Your Plan: ");
        allRiskBox = new JCheckBox("All Risk");
        obligatoryBox = new JCheckBox("Obligatory");
        vehicleDmgBox = new JCheckBox("Vehicle Damage");
        driverDmgBox = new JCheckBox("Driver Damage");
        assistanceBox = new JCheckBox("Assistance");

        GetRiskCoveredByPlan();

        PlanPanel.add(selectLabel);
        PlanPanel.add(allRiskBox);
        PlanPanel.add(obligatoryBox);
        PlanPanel.add(vehicleDmgBox);
        PlanPanel.add(driverDmgBox);
        PlanPanel.add(assistanceBox);

        PlanPanel.setBounds(345,15,300,200);
        PlanPanel.setLayout(new GridLayout(6,1));
        add(PlanPanel);
    }

    private void CustomizeValidityPanel(){
        JPanel validityPanel = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,2),
                "Validity",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor
        );
        validityPanel.setBorder(titledBorder);

        todayL = new JLabel();
        df = new SimpleDateFormat("dd/MM/yyyy");
        currentDate = new Date();
        todayL.setText("Today: "+df.format(currentDate));
        todayL.setOpaque(false);

        Font font = todayL.getFont();
        float size = font.getSize() + 3.0f;
        todayL.setFont(font.deriveFont(size));

        oneYear = new JRadioButton();
        oneYear.setText("One Year");
        twoYears = new JRadioButton();
        twoYears.setText("Two Years");
        threeYears = new JRadioButton();
        threeYears.setText("Three Years");
        Buttons2 = new ButtonGroup();
        Buttons2.add(oneYear);
        Buttons2.add(twoYears);
        Buttons2.add(threeYears);

        oneYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYear = 1;
            }
        });

        twoYears.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYear = 2;
            }
        });

        threeYears.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validityYear = 3;
            }
        });

        validityPanel.add(todayL);
        validityPanel.add(spacer);
        validityPanel.add(oneYear);
        validityPanel.add(twoYears);
        validityPanel.add(threeYears);
        validityPanel.add(spacer);

        validityPanel.setBounds(345,225,300,250);
        validityPanel.setLayout(new GridLayout(6,1));

        add(validityPanel);

    }

    private void CustomizeActionsPanel(){
        JPanel actionsPanel = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,2),
                "Actions",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor
        );
        actionsPanel.setBorder(titledBorder);

        showBTN = new JButton("Show Plan Details");
        saveBTN = new JButton("Save Customer");
        newBTN = new JButton("New Customer");
        loadBTN = new JButton("Load Customer");
        deleteBTN = new JButton("Delete Customer");
        enterMobileNr = new JTextField("Enter Phone Number");

        showBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String risk = "";
                    for (int i = 0; i < coveredRisksList.size(); i++)
                        risk += coveredRisksList.get(i) + "\n";
                    risks.setText(risk);
                try {
                    policyDetails.setText(getPolicyData().toString());
                    DisplayPaymentsOfPolicy();
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
        });

        saveBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SaveCustomerMapToDisk();
                } catch (IOException | ClassNotFoundException | ParseException ex) {
                    ex.printStackTrace();
                }
            }
        });

        newBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    newCustomer();
            }
        });

        loadBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    searchCustomerByMobileNumber();

                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        deleteBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("../data.dat");
                try {
                    InputStream is = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(is);

                    TreeMap<Integer,Customer> mapInFile = (TreeMap<Integer,Customer>) ois.readObject();
                    ois.close();
                    is.close();

                    mapInFile.remove(Integer.parseInt(enterMobileNr.getText()));

                    OutputStream os = new FileOutputStream(file);
                    ObjectOutputStream oos = new ObjectOutputStream(os);

                    oos.writeObject(mapInFile);
                    oos.flush();
                    os.close();
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        actionsPanel.add(showBTN);
        actionsPanel.add(saveBTN);
        actionsPanel.add(newBTN);
        actionsPanel.add(enterMobileNr);
        actionsPanel.add(loadBTN);
        actionsPanel.add(deleteBTN);

        actionsPanel.setBounds(345,475,300,250);
        actionsPanel.setLayout(new GridLayout(6,1));

        add(actionsPanel);
    }

    private void CustomizeCoveredRisksPanel(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,2),
                "Covered Risks",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor
        );
        JPanel riskPanel = new JPanel();
        riskPanel.setBorder(titledBorder);

        risks = new JTextArea(7,1);
        risks.setOpaque(false);
        risks.setEditable(false);
        risks.setLineWrap(true);

        Font font = risks.getFont();
        float size = font.getSize() + 3.0f;
        risks.setFont(font.deriveFont(size));

        riskPanel.add(risks);
        riskPanel.setBounds(675,15,300,200);
        riskPanel.setLayout(new GridLayout(1,1));
        add(riskPanel);
    }

    private void CustomizePolicyPanel(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,2),
                "Policy Details",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor
        );
        JPanel policyPanel = new JPanel();
        policyPanel.setBorder(titledBorder);

        policyDetails = new JTextArea(7,1);
        policyDetails.setLineWrap(true);
        policyDetails.setOpaque(false);
        policyDetails.setEditable(false);

        Font font = policyDetails.getFont();
        float size = font.getSize() + 3.0f;
        policyDetails.setFont(font.deriveFont(size));

        policyPanel.add(policyDetails);

        policyPanel.setBounds(675,225,300,250);
        policyPanel.setLayout(new GridLayout(1,1));
        add(policyPanel);
    }

    private void CustomizeCustomerDataPanel(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,2),
                "Customer Details",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor
        );
        JPanel customerDataPanel = new JPanel();
        customerDataPanel.setBorder(titledBorder);

        customerDetails = new JTextArea(7,1);
        customerDetails.setLineWrap(true);
        customerDetails.setOpaque(false);
        customerDetails.setEditable(false);

        Font font = customerDetails.getFont();
        float size = font.getSize() + 3.0f;
        customerDetails.setFont(font.deriveFont(size));

        customerDataPanel.add(customerDetails);

        customerDataPanel.setBounds(675,475,300,250);
        customerDataPanel.setLayout(new GridLayout(1,1));
        add(customerDataPanel);
    }

    private void CustomizeClaimPanel(){

        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,2),
                "Customer Details",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor
        );
        JPanel claimPanel = new JPanel();
        claimPanel.setBorder(titledBorder);

        JLabel enterPlate = new JLabel("Enter Phone Number of Claiming Customer");
        customerNumber = new JTextField();
        customerNumber.setPreferredSize(new Dimension(250,25));

        ArrayList<String> risksClaimedList = new ArrayList<>();

        searchCustomer = new JButton("Search Customer");
        searchCustomer.setPreferredSize(new Dimension(200,25));
        searchCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cond1 = false;
                cond2 = false;
                cond3 = false;
                try{
                    risksClaimedList.clear();
                    Customer c = claimsSearchCustomerByMobileNumber();
                    claimingCustomerName.setText("Claiming Customer: "+c.getFirstName()+" "+c.getLastName());
                    cond1 = true;

                    claimingCustomerRisksCovered.setText("Covered Risks by customer plan: ");
                    for(int i=0;i<c.getPolicy().getRisksCoveredList().size();i++){
                        risksClaimedList.add(c.getPolicy().getRisksCoveredList().get(i));
                        claimingCustomerRisksCovered.setText(claimingCustomerRisksCovered.getText()+"\n"+c.getPolicy().getRisksCoveredList().get(i));
                        coveredRisksList.add(c.getPolicy().getRisksCoveredList().get(i));
                    }

                    LocalDate validityOfPolicy = c.getPolicy().getPolicyDate();
                    int policyYear = c.getPolicy().getValidityYear();
                    validityOfPolicy = validityOfPolicy.plusYears(policyYear);
                    CheckPolicyValidity(validityOfPolicy);

                    claimingCustomerPolicyValidity.setText("Date Validity Of Policy: "+validityOfPolicy);

                    if(c.getPolicy().getRisksCoveredList().size()>=5) cond2 = true;
                }
                catch(Exception er){
                        claimingCustomerName.setText("Claiming Customer: Not Found");
                }
            }
        });

        JLabel selectDamage = new JLabel("Select the Type of Damage or Assistance Needed: ");

        String[] items = {
                "Vehicle Damage",
                "Third Party Damage",
                "Driver Damage",
                "Fire",
                "Robbery",
                "Transport",
                "Car Replacement"
        };
        JLabel spacer2 = new JLabel("                               ");

        final JList<String> claimList = new JList<>(items);
        claimList.setOpaque(false);
        claimList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        claimList.setPreferredSize(new Dimension(250,200));

        confirmClaim = new JButton("Confirm Claim");
        confirmClaim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectedIn = claimList.getSelectedIndices();
                List<String>claimedList = new ArrayList<>();

                for(int i=0;i<selectedIn.length;i++)
                    claimedList.add(claimList.getModel().getElementAt(selectedIn[i]));

                if(!cond2)
                    cond2 = coveredRisksList.containsAll(claimedList);

                ClaimIsValid();

                try {
                    Customer c = claimsSearchCustomerByMobileNumber();
                    if(ClaimIsValid()){
                        int money = c.getPolicy().getVehicle().getEstimatedValue();
                        if(claimedList.contains("Fire")){
                            settlementArea.setText(settlementArea.getText()+"\nFire Department: "+money*0.01+" $");
                        }
                        if(claimedList.contains("Robbery")){
                            settlementArea.setText(settlementArea.getText()+"\nProSec Company: "+money*0.1+" $");
                        }
                        if(claimedList.contains("Transport")){
                            settlementArea.setText(settlementArea.getText()+"\nTransport Company: "+money*0.2+" $");
                        }
                        if(claimedList.contains("Car Replacement")){
                            settlementArea.setText(settlementArea.getText()+"\nCar Replacement: "+money*0.95+" $");
                        }
                        if(claimedList.contains("Driver Damage")){
                            settlementArea.setText(settlementArea.getText()+"\nHospital: 1000 $");
                        }
                        if(claimedList.contains("Third Party Damage")){
                            settlementArea.setText(settlementArea.getText()+"\nPay for Third Party Driver: 2000 $");
                        }
                        if(claimedList.contains("Vehicle Damage")){
                            settlementArea.setText(settlementArea.getText()+"\nService: "+money*0.15+" $");
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        claimPanel.add(enterPlate);
        claimPanel.add(customerNumber);
        claimPanel.add(searchCustomer);
        claimPanel.add(spacer2);
        claimPanel.add(selectDamage);
        claimPanel.add(claimList);
        claimPanel.add(confirmClaim);

        claimPanel.setBounds(1000,15,300,460);
        add(claimPanel);
    }

    private void CustomizeClaimStatusPanel(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,2),
                "Claim Status",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor
        );
        JPanel claimStatus = new JPanel();
        claimStatus.setBorder(titledBorder);

        claimingCustomerName = new JLabel("Claiming Customer: ");
        claimingCustomerPolicyValidity = new JLabel("Date Validity of Policy: ");
        claimingCustomerRisksCovered = new JTextArea();
        claimingCustomerRisksCovered.setOpaque(false);
        claimingCustomerRisksCovered.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(claimingCustomerRisksCovered);
        claimingCustomerStatus = new JLabel("Claiming Status: ");

        claimStatus.add(claimingCustomerName);
        claimStatus.add(claimingCustomerPolicyValidity);
        claimStatus.add(scrollPane);
        claimStatus.add(claimingCustomerStatus);

        claimStatus.setBounds(1000,475,300,250);
        claimStatus.setLayout(new GridLayout(4,1));
        add(claimStatus);

    }

    private void CustomizePaymentPanel(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,2),
                "Payments",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor
        );
        JPanel paymentPanel = new JPanel();
        paymentPanel.setBorder(titledBorder);

        paymentArea = new JTextArea(7,1);
        paymentArea.setLineWrap(true);
        paymentArea.setOpaque(false);
        paymentArea.setEditable(false);

        Font font = paymentArea.getFont();
        float size = font.getSize() + 3.0f;
        paymentArea.setFont(font.deriveFont(size));

        paymentPanel.add(paymentArea);

        paymentPanel.setBounds(1315,15,300,250);
        paymentPanel.setLayout(new GridLayout(1,1));
        add(paymentPanel);
    }

    private void CustomizeSettlementPanel(){
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.gray,2),
                "Settlements",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor
        );
        JPanel settlementPanel = new JPanel();
        settlementPanel.setBorder(titledBorder);

        settlementArea = new JTextArea(18,1);
        settlementArea.setLineWrap(true);
        settlementArea.setOpaque(false);
        settlementArea.setEditable(false);
        settlementArea.setPreferredSize(new Dimension(250,300));

        Font font = settlementArea.getFont();
        float size = font.getSize() + 3.0f;
        settlementArea.setFont(font.deriveFont(size));

        resetAll = new JButton("Reset all Payments and Claims");
        resetAll.setPreferredSize(new Dimension(250,30));
        resetAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settlementArea.setText("");
                paymentArea.setText("");
                claimingCustomerName.setText("Claiming Customer: ");
                claimingCustomerPolicyValidity.setText("Date Validity of Policy:");
                claimingCustomerStatus.setText("Claiming Status: ");
                claimingCustomerRisksCovered.setText("");
            }
        });

        settlementPanel.add(settlementArea);
        settlementPanel.add(resetAll);

        settlementPanel.setBounds(1315,275,300,450);
        add(settlementPanel);
    }

    //Methods

    public Customer getCustomerData() throws ParseException {

        Customer customerData = new Customer(
                fNameSub.getText(),
                lNameSub.getText(),
                citySub.getText(),
                Integer.parseInt(phoneSub.getText()),
                getPolicyData()
        );
        return customerData;
    }

    public Vehicle getVehicleData() throws ParseException{

        Vehicle vehicle = new Vehicle(
                platenrSub.getText(),
                Integer.parseInt(modelYearSub.getText()),
                manufacturerName.getSelectedItem().toString(),
                Integer.parseInt(estimatedValueSub.getText()),
                getCarDamage()
        );
        return vehicle;
    }

    public Policy getPolicyData() throws ParseException {

        currentDate = new Date();

        LocalDate now = LocalDate.now();

        Policy policy = new Policy(
                getVehicleData(),
                coveredRisksList,
                premiumRisksList,
                coverageRisksList,
                ceilingRisksList,
                validityYear,
                now
        );
        return policy;
    }

    public int getCarDamage(){

        if(motorButton.isSelected())
            return 1;
        else if(bodyButton.isSelected())
            return 2;
        else if(wheelButton.isSelected())
            return 3;
        else return 0;
    }

    public void GetRiskCoveredByPlan(){

        coveredRisksList.clear();
        allRiskBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!allRiskBox.isSelected()) {
                    obligatoryBox.setEnabled(true);
                    vehicleDmgBox.setEnabled(true);
                    driverDmgBox.setEnabled(true);
                    assistanceBox.setEnabled(true);

                    AllRisk allRisk = new AllRisk();
                    for (int i = 0; i < allRisk.AllRisksCovered.length; i++)
                        coveredRisksList.remove(allRisk.AllRisksCovered[i]);
                } else {
                    obligatoryBox.setEnabled(false);
                    vehicleDmgBox.setEnabled(false);
                    driverDmgBox.setEnabled(false);
                    assistanceBox.setEnabled(false);

                    AllRisk allRisk = new AllRisk();
                    for (int i = 0; i < allRisk.AllRisksCovered.length; i++)
                        coveredRisksList.add(allRisk.AllRisksCovered[i]);
                    premiumRisksList.add(allRisk.getPremium());
                    coverageRisksList.add(allRisk.getCoverage());
                    ceilingRisksList.add(allRisk.getCeiling());
                }
            }
        });

        assistanceBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(assistanceBox.isSelected()) {
                    AssistanceRisk assistanceRisk = new AssistanceRisk();
                    for (int i = 0; i < assistanceRisk.AssistanceRisksCovered.length; i++)
                        coveredRisksList.add(assistanceRisk.AssistanceRisksCovered[i]);
                    premiumRisksList.add(assistanceRisk.getPremium());
                    coverageRisksList.add(assistanceRisk.getCoverage());
                    ceilingRisksList.add(assistanceRisk.getCeiling());
                }
                else{
                    AssistanceRisk assistanceRisk = new AssistanceRisk();
                    for (int i = 0; i < assistanceRisk.AssistanceRisksCovered.length; i++)
                        coveredRisksList.remove(assistanceRisk.AssistanceRisksCovered[i]);
                }
            }
        });

        driverDmgBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(driverDmgBox.isSelected()) {
                    DriverRisk driverRisk = new DriverRisk();
                    coveredRisksList.add(driverRisk.DriverRisksCovered[0]);
                    premiumRisksList.add(driverRisk.getPremium());
                    coverageRisksList.add(driverRisk.getCoverage());
                    ceilingRisksList.add(driverRisk.getCeiling());
                }
                else{
                    DriverRisk driverRisk = new DriverRisk();
                    coveredRisksList.remove(driverRisk.DriverRisksCovered[0]);
                }
            }
        });

        obligatoryBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(obligatoryBox.isSelected()) {
                    ObligatoryRisk obligatoryRisk = new ObligatoryRisk();
                    for (int i = 0; i < obligatoryRisk.ObligatoryRisksCovered.length; i++)
                        coveredRisksList.add(obligatoryRisk.ObligatoryRisksCovered[i]);
                    premiumRisksList.add(obligatoryRisk.getPremium());
                    coverageRisksList.add(obligatoryRisk.getCoverage());
                    ceilingRisksList.add(obligatoryRisk.getCeiling());
                }
                else{
                    ObligatoryRisk obligatoryRisk = new ObligatoryRisk();
                    for(int i=0;i<obligatoryRisk.ObligatoryRisksCovered.length;i++)
                        coveredRisksList.remove(obligatoryRisk.ObligatoryRisksCovered[i]);
                }
            }
        });

        vehicleDmgBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(vehicleDmgBox.isSelected()) {
                    VehicleRisk vehicleRisk = new VehicleRisk();
                    coveredRisksList.add(vehicleRisk.VehicleRisksCovered[0]);
                    premiumRisksList.add(vehicleRisk.getPremium());
                    coverageRisksList.add(vehicleRisk.getCoverage());
                    ceilingRisksList.add(vehicleRisk.getCeiling());
                }
                else{
                    VehicleRisk vehicleRisk = new VehicleRisk();
                    coveredRisksList.remove(vehicleRisk.VehicleRisksCovered[0]);
                }
            }
        });
    }

    public void newCustomer(){

        coveredRisksList.clear();
        coverageRisksList.clear();
        ceilingRisksList.clear();
        premiumRisksList.clear();
        cond1 = false;
        cond2 = false;
        cond3 = false;

        fNameSub.setText("");
        lNameSub.setText("");
        citySub.setText("");
        phoneSub.setText("");

        platenrSub.setText("");
        modelYearSub.setText("");
        manufacturerName.setSelectedItem("Acura");
        estimatedValueSub.setText("");

        Buttons1.clearSelection();
        Buttons2.clearSelection();

        obligatoryBox.setSelected(false);
        allRiskBox.setSelected(false);
        vehicleDmgBox.setSelected(false);
        driverDmgBox.setSelected(false);
        assistanceBox.setSelected(false);

        obligatoryBox.setEnabled(true);
        vehicleDmgBox.setEnabled(true);
        driverDmgBox.setEnabled(true);
        assistanceBox.setEnabled(true);

        policyDetails.setText("");
        risks.setText("");
    }

    public void SaveCustomerMapToDisk() throws IOException, ClassNotFoundException, ParseException {

        File file = new File("../data.dat");
        Integer mobilePhone = Integer.parseInt(phoneSub.getText());

        TreeMap<Integer,Customer> newMapToSave = new TreeMap<>();

        if(file.length()>0) {
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            TreeMap<Integer, Customer> currentMap = (TreeMap<Integer, Customer>) ois.readObject();
            ois.close();
            is.close();
            newMapToSave.putAll(currentMap);
        }
        newMapToSave.put(mobilePhone,getCustomerData());

        OutputStream os = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(newMapToSave);
        oos.flush();
        os.close();
    }

    private void searchCustomerByMobileNumber() throws IOException, ClassNotFoundException {

        File file = new File("../data.dat");

        InputStream is = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(is);

        TreeMap<Integer,Customer> mapInFile = (TreeMap<Integer,Customer>) ois.readObject();
        ois.close();
        is.close();

        Customer foundCustomer = mapInFile.get(Integer.parseInt(enterMobileNr.getText()));
        customerDetails.setText(foundCustomer.toString());
    }

    private Customer claimsSearchCustomerByMobileNumber() throws IOException, ClassNotFoundException {

        Customer customer = new Customer();
        File file = new File("../data.dat");

        InputStream is = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(is);

        TreeMap<Integer,Customer> mapInFile = (TreeMap<Integer,Customer>) ois.readObject();
        ois.close();
        is.close();

        customer = mapInFile.get(Integer.parseInt(customerNumber.getText()));
        return customer;
    }

    private void CheckPolicyValidity(LocalDate validDate){
        LocalDate now = LocalDate.now();
        cond3 = now.isBefore(validDate);
    }

    private boolean ClaimIsValid(){

        if(cond1 && cond2 && cond3){
            claimingCustomerStatus.setText("Claiming Status: You can register the claim");
            return true;
        }
        else{
            claimingCustomerStatus.setText("Claiming Status: Not able to register the claim");
            return false;
        }
    }

    private void DisplayPaymentsOfPolicy(){

        for(int i=0; i<premiumRisksList.size();i++){
            totalPremium += premiumRisksList.get(i);
            totalCeiling += ceilingRisksList.get(i);
            totalCoverage += coverageRisksList.get(i);
        }
        paymentArea.setText(
                "Total Premium: "+ totalPremium*Integer.parseInt(estimatedValueSub.getText())/10+" $\n"+
                "Total Coverage: "+ totalCoverage*Integer.parseInt(estimatedValueSub.getText())*10 + " $\n"+
                "Maximum Ceiling: "+ totalCeiling*(Integer.parseInt(estimatedValueSub.getText())+100000)/10+" $\n"
        );
    }

    public static void main(String[] args){

        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainScreen.setBounds(0,0,1640,860);
        mainScreen.setTitle("Insurance Software");

    }
}
