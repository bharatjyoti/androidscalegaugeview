Android custom gauge/scale UI. That can be used with progress bar or other value based Android UI component.
Uses- Add below lines in your layout xml file-

 <view  android:layout_width="wrap_content"
        android:layout_height="20dp"
        class="com.bhazarika.gaugeviewui.GaugeView"
        android:layout_marginTop="3dp"
        android:layout_below="@+id/progressBar"
        android:layout_alignLeft="@+id/progressBar"
        android:layout_alignStart="@+id/progressBar"
        android:id="@+id/gauge"
        android:layout_alignRight="@+id/progressBar"
        android:layout_alignEnd="@+id/progressBar" />
