/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import gnu.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.TooManyListenersException;
import javax.swing.JOptionPane;

/**
 *
 * @author Angelo
 */
public class CashDrawerController implements SerialPortEventListener {

    SerialPort serialPort;
    private BufferedReader input;
    private OutputStream output;
    private static final int TIME_OUT = 2000;
    private static final int DATA_RATE = 9600;
    private String comPort;
    public boolean keepRunning;

    public CashDrawerController() {
        keepRunning = true;
    }

    public void getPortConfig() {
        ReadXMLFile reader = new ReadXMLFile();
        comPort = reader.readFile()[0];
    }

    public void initialize() {
        getPortConfig();
        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        //First, Find an instance of serial port as set in PORT_NAMES.
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            if (currPortId.getName().equals(comPort)) {
                portId = currPortId;
                break;
            }
        }
        if (portId == null) {
            keepRunning = false;
            System.out.println("Could not find COM port.");
            return;
        }

        try {
            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) portId.open(this.getClass().getName(),
                    TIME_OUT);

            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            // open the streams
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();

            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (PortInUseException | UnsupportedCommOperationException
                | IOException | TooManyListenersException e) {
            System.err.println(e.toString());
            keepRunning = false;
        }
    }

    public void sendData(String data) {
        try {
            PrintStream printer = new PrintStream(output);
            printer.print(data);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    /**
     * Handle an event on the serial port. Read the data and print it.
     *
     * @param oEvent
     */
    @Override
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputLine = input.readLine();
                if(inputLine.equals("the cash drawer is already open")){
                    JOptionPane.showMessageDialog(null, "La caja ya esta abierta.");
                } else if(inputLine.equals("the cash drawer is already closed")){
                    JOptionPane.showMessageDialog(null, "La caja ya esta cerrada.");
                }
                System.out.println(inputLine);

            } catch (IOException e) {
                System.err.println(e.toString());
            }
        }
        // Ignore all the other eventTypes, but you should consider the other ones.
    }

    public void runComm() {
        initialize();
        /*Thread t = new Thread() {
            public void run() {
                while (keepRunning);
            }
        };
        t.start();*/
        System.out.println("Started");
    }
    
}
