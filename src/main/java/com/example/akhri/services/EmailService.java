package com.example.akhri.services;

import com.example.akhri.model.Bank;
import com.example.akhri.model.Register;
import com.example.akhri.repository.Bankrepo;
import com.example.akhri.repository.Regrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private Regrepo regrepo;
    @Autowired
    private Bankrepo bankrepo;


    public String sendVerificationEmail(String userEmail,String mobileno) {
        // Check if a profile with the same mobile number already exists
        if (regrepo.existsByMobileno(mobileno)) {
            return "Mobile number already exists. You can log in with that number.";
        }
        // Generate a 6-digit verification code
        String verificationCode = String.format("%06d", new Random().nextInt(999999));

        // Create the email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("jlss.virtual.0808@gmail.com");
        message.setTo(userEmail);
        message.setSubject("Verification Code");
        message.setText("Your verification code is: " + verificationCode);

        // Send the email
        mailSender.send(message);

        // Return the code to compare later
        return verificationCode;
    }

    public String bankvarificaioncode(String useremail,String name ,String bankname) {



        String verificationCode = String.format("%06d", new Random().nextInt(999999));

        // Create the email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("jlss.virtual.0808@gmail.com");
        message.setTo(useremail);
        message.setSubject("Verification Code - "+bankname +" bank");
        message.setText(" welcome  "+name+"\n\n Your verification code is: " + verificationCode+".\n of " +
                bankname);

        // Send the email
        mailSender.send(message);

        // Return the code to compare later
        return verificationCode;
    }

    public void senddeletionEmail(String userEmail, String username) {
        // Create the email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("jlss.virtual.0808@gmail.com");
        message.setTo(userEmail);
        message.setSubject("Account Deletion Confirmation - Virtual Bank App");

        // Email body text
        message.setText(
                " Dear "+username+",\n\n"+
                        "We would like to inform you that your account with the Virtual Bank App has been successfully deleted as per your request.\n" +
                        "All your data has been removed from our system, and you will no longer have access to your account or any related services.\n\n" +
                        "If this was done in error or you wish to reactivate your account, please don't hesitate to contact our support team at support@jlsscorporation.com.\n\n" +
                        "We appreciate the time you've spent with us and hope to serve you again in the future.\n\n" +
                        "Best regards,\n" +
                        "JLSS & Corporation\n" +
                        "Owner: Jeet Solanki\n\n" +
                        "This is an automated message, please do not reply."
        );

        // Send the email
        mailSender.send(message);
    }

    public void sendCreatingNewAccEmail(String userEmail, String name) {
        // Create the email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("jlss.virtual.0808@gmail.com");
        message.setTo(userEmail);
        message.setSubject("Welcome to the World of Virtual Banks - JLSS & Corporation");

        // Email body text
        message.setText(
                "Welcome to the World of Virtual Banks, Dear " + name + ",\n\n" +
                        "We are thrilled to have you as a part of our ever-growing virtual banking family! Our app provides all the essential features that a real-world bank offers, and much more.\n\n" +
                        "Here’s what you can do with the Virtual Bank App:\n" +
                        "  - Create and manage bank accounts with multiple virtual banks\n" +
                        "  - Perform secure transactions using our virtual currency (cryptocurrency)\n" +
                        "  - Enjoy seamless banking experiences tailored to your needs\n\n" +
                        "Our virtual currency ensures that all your transactions remain secure and transparent. While we are constantly improving, you can expect more exciting features in the near future!\n\n" +
                        "Feel free to explore the app, and don’t hesitate to reach out to our support team if you have any questions.\n\n" +
                        "Best regards,\n" +
                        "JLSS & Corporation\n" +
                        "Owner: Jeet Solanki\n\n" +
                        "This is an automated message, please do not reply."
        );

        // Send the email
        mailSender.send(message);
    }

    public void sendBankAccCreatingEmail(String userEmail, String bankName, String name) {
        // Create the email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("jlss.virtual.0808@gmail.com");
        message.setTo(userEmail);
        message.setSubject("Welcome to " + bankName + " - JLSS & Corporation");

        // Email body text
        message.setText(
                "Dear " + name + ",\n\n" +
                        "Welcome to " + bankName + " and thank you for choosing us as your trusted banking partner! We are delighted to have you onboard as a valued customer.\n\n" +
                        bankName + " offers a wide range of services designed to help you manage your financial needs efficiently:\n" +
                        "  - **Secure Account Management**: Open, manage, and maintain multiple bank accounts with ease.\n" +
                        "  - **Fast and Reliable Transactions**: Perform local and international transfers with enhanced security.\n" +
                        "  - **Virtual Currency**: Utilize our integrated cryptocurrency for safe and secure digital transactions.\n" +
                        "  - **Financial Insights**: Get detailed insights into your spending and savings with easy-to-understand reports.\n" +
                        "  - **24/7 Customer Support**: Our dedicated support team is always available to assist with any queries.\n\n" +
                        "At " + bankName + ", we prioritize the safety of your transactions and the ease of managing your financial assets. We are constantly working to enhance our features to serve you better.\n\n" +
                        "Thank you for choosing us as your banking partner. We look forward to supporting you on your financial journey.\n\n" +
                        "Best regards,\n" +
                        "JLSS & Corporation\n" +
                        "Owner: Jeet Solanki\n\n" +
                        "This is an automated message, please do not reply."
        );

        // Send the email
        mailSender.send(message);
    }

    public void sendBankerWelcomeEmail(String userEmail, String bankerName) {
        // Create the email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("jlss.virtual.0808@gmail.com");
        message.setTo(userEmail);
        message.setSubject("Welcome to the World of Virtual Banking - JLSS & Corporation");

        // Email body text
        message.setText(
                "Dear " + bankerName + ",\n\n" +
                        "Welcome to the world of virtual banking! As a Banker, you now have the power to build and manage your own virtual banking empire, without the need for a single brick. At JLSS & Corporation, we are excited to provide you with all the tools and features you need to succeed in this innovative virtual banking space.\n\n" +
                        "Here’s what you can do as a Banker:\n" +
                        "  - **Create Unlimited Virtual Banks**: You can set up and manage as many virtual banks as you desire, each operating with the efficiency of a real-world bank.\n" +
                        "  - **Appoint Managers and Employees**: Add managers to oversee operations, and employ staff to ensure smooth banking activities.\n" +
                        "  - **Handle Bank Funds**: Manage the financial health of your banks, oversee funds, and make critical financial decisions just like a real banker.\n" +
                        "  - **Managers Handle Operations**: Delegating responsibility to managers, who will handle employees and oversee the daily operations and status of the bank.\n\n" +
                        "As a banker, you have full control over the entire system and the ability to manage your virtual banks in the most efficient manner. We’re constantly working on new updates to enhance your experience, ensuring you can run your virtual banks with ease and precision.\n\n" +
                        "Thank you for choosing JLSS & Corporation as your trusted platform for virtual banking. We look forward to supporting your journey as you build and grow your virtual banking empire.\n\n" +
                        "Best regards,\n" +
                        "JLSS & Corporation\n" +
                        "Owner: Jeet Solanki\n\n" +
                        "This is an automated message, please do not reply."
        );

        // Send the email
        mailSender.send(message);
    }



}
