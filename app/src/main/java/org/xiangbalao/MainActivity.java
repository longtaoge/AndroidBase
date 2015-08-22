package org.xiangbalao;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import org.xiangbalao.androidbase.R;
import org.xiangbalao.bankcardview.BankCardinputView;
public class MainActivity extends Activity {

	TextView textView;
	
	Button mButton,mButton2;
	
	BankCardinputView mBankCardinputView;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        textView=(TextView) findViewById(R.id.textView);
        
        mBankCardinputView=(BankCardinputView) findViewById(R.id.bankcard);
        
        mButton=(Button) findViewById(R.id.button);
        
        mButton2=(Button) findViewById(R.id.button2);
        mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				textView.setText(mBankCardinputView.getNumber());
			}
		});
        mButton2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mBankCardinputView.fillViewData("3456879823452345");
				
			}
		});
        
        
        
    }


  


}
