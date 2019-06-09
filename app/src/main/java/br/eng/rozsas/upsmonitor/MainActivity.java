package br.eng.rozsas.upsmonitor;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MYDEBUG: " + MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d (TAG, "before create a new oidDataList");

        // Create an ArrayList to populate the List View
        ArrayList<OIDData> oidDataList= new ArrayList<>();

        // General information about device
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.2.4.2.1.3.1", "lgpAgentDeviceManufacturer.1", "Manufacturer", 0.0f, ResultType.STRING, new String[] {}, ""));
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.2.4.2.1.4.1", "lgpAgentDeviceModel.1", "Model", 0.0f, ResultType.STRING, new String[] {}, ""));
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.2.4.2.1.7.1", "lgpAgentDeviceSerialNumber.1", "UPS serial number", 0.0f, ResultType.STRING, new String[] {}, ""));
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.2.1.4.0", "lgpAgentIdentSerialNumber.0", "SNMP card serial number", 0.0f, ResultType.STRING, new String[] {}, ""));
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.2.4.2.1.8.1", "lgpAgentDeviceManufactureDate.1", "Device Manufacture Date", 0.0f, ResultType.STRING, new String[] {}, ""));
        // Inverter and bypass status
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.3.5.3.7.0", "lgpPwrOutputToLoadOnInverter.0", "Load On Inverter ?", 0.0f, ResultType.LIST_OF_CHOICES, new String[] {"yes", "no"}, ""));
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.3.5.3.9.0", "lgpPwrInverterReady.0", "Inverter Status", 0.0f, ResultType.LIST_OF_CHOICES, new String [] {"on", "off"}, ""));
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.3.5.3.10.0", "lgpPwrOutputToLoadOnBypass.0", "Load on bypass ?", 0.0f, ResultType.LIST_OF_CHOICES, new String [] {"yes", "no"}, ""));
        // Battery info
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.3.5.2.4.1.4.1", "lgpPwrDcMeasurementPointVolts.1", "Battery Voltage", 0.0f, ResultType.NUMERIC, new String[] {}, " VDC"));
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.3.5.1.10.0", "lgpPwrBatteryFloatVoltage.0", "Battery Float Voltage", 0.0f, ResultType.NUMERIC, new String[] {}, " VDC"));
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.3.5.1.18.0", "lgpPwrBatteryTimeRemaining.0", "Battery Time Remaining", 0.0f, ResultType.NUMERIC, new String[] {}, " min."));
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.3.5.1.14.0", "lgpPwrBatteryChargeStatus.0", "Battery Charge Status", 0.0f, ResultType.LIST_OF_CHOICES, new String[] {"charged", "charging"}, ""));
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.3.5.1.16.0", "lgpPwrBatteryCharger.0", "? Battery Charger", 0.0f, ResultType.STRING, new String[] {}, ""));
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.3.5.3.8.0", "lgpPwrBatteryChargeCompensating.0", "Battery Charge Compensating ?", 0.0f, ResultType.LIST_OF_CHOICES, new String[] {"yes", "no"}, ""));
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.3.5.1.19.0", "lgpPwrBatteryCapacity.0", "Battery Capacity", 0.0f, ResultType.NUMERIC, new String[] {}, " Ah"));
        // Input VIF
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.3.5.2.3.1.20.1.1", "lgpPwrLineMeasurementVolts.1.1", "Input Voltage", 0.0f, ResultType.NUMERIC, new String[] {}, " VAC"));
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.3.5.2.2.1.6.1", "lgpPwrMeasurementPointFrequency.1", "Input frequency", 0.0f, ResultType.NUMERIC, new String[] {}, " Hz"));
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.3.5.2.3.1.6.1.1", "lgpPwrLineMeasurementCurrent.1.1", "Input current", 1.0f, ResultType.NUMERIC, new String[] {}, " A"));
        oidDataList.add(new OIDData(".1.3.6.1.2.1.33.1.3.3.1.4.1", "UPS-MIB::upsInputCurrent.1", "Input current", 0.1f, ResultType.NUMERIC, new String[] {}, " A"));
        // Output VIF
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.3.5.2.3.1.20.3.1", "lgpPwrLineMeasurementVolts.3.1", "Output Voltage", 0.0f, ResultType.NUMERIC, new String[] {}, " VAC"));
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.3.5.2.2.1.6.3", "lgpPwrMeasurementPointFrequency.3", "Output frequency ", 0.0f, ResultType.NUMERIC, new String[] {}, " Hz"));
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.3.5.2.3.1.6.3.1", "lgpPwrLineMeasurementCurrent.3.1", "Output current", 1.0f, ResultType.NUMERIC, new String[] {}, " A"));
        oidDataList.add(new OIDData(".1.3.6.1.2.1.33.1.4.4.1.3.1", "UPS-MIB::upsOutputCurrent.1", "Output current", 0.1f, ResultType.NUMERIC, new String[] {}, " A"));
        // Output Power
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.3.5.2.2.1.7.3", "lgpPwrMeasurementPointApparentPower.3", "Output Apparent Power", 0.0f, ResultType.NUMERIC, new String[] {}, " W"));
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.3.5.2.2.1.8.3", "lgpPwrMeasurementPointTruePower.3", "True Power", 0.0f, ResultType.NUMERIC, new String[] {}, " W"));
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.3.5.2.3.1.8.3.1", "lgpPwrLineMeasurementVA.3.1", "Output Power", 0.0f, ResultType.NUMERIC, new String[] {}, " VA"));
        // Output power as percent
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.3.5.2.2.1.11.3", "lgpPwrMeasurementPointVAPercent.3", "Percentage of nominal power", 0.0f, ResultType.NUMERIC, new String[] {}, "%"));
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.3.5.2.3.1.19.3.1", "lgpPwrLineMeasurementPercentLoad.3.1", "Percentage of nominal power", 0.0f, ResultType.NUMERIC, new String[] {}, "%"));
        // Misc
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.3.4.1.3.3.1.3.1", "lgpEnvTemperatureMeasurementDegC.1", "Internal temperature", 0.0f, ResultType.NUMERIC, new String[] {}, " ºC"));
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.3.5.8.1.0", "lgpPwrBrownOutCount.0", "Brownout count", 0.0f, ResultType.NUMERIC, new String[] {}, " times"));
        oidDataList.add(new OIDData(".1.3.6.1.4.1.476.1.42.3.5.8.2.0", "lgpPwrBlackOutCount.0", "Blackout Count", 0.0f, ResultType.NUMERIC, new String[] {}, " times"));

        // get a reference to our basic  list view
        Log.d(TAG, "find the list view");
        ListView listView= findViewById(R.id.list_view);

        // create an  array adapter for our oidDataList
        Log.d(TAG, "create an adapter");
        OIDDataAdapter adapter= new OIDDataAdapter (this, oidDataList);

        // attach the adapter to the list view
        Log.d(TAG, "set the adapter");
        listView.setAdapter(adapter);
    }
}
