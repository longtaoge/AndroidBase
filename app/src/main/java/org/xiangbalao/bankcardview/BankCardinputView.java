package org.xiangbalao.bankcardview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import org.xiangbalao.androidbase.R;

public class BankCardinputView extends RelativeLayout {

	/**
	 * 输入的数字
	 */
	private String inputNumber;
	/**
	 * 卡片类型
	 */
	private String cardType = "16";

	// 16位账户号码
	private EditText acount_num1_value;
	private EditText acount_num2_value;
	private EditText acount_num3_value;
	private EditText acount_num4_value;
	private EditText acount_num5_value;
	private EditText acount_num6_value;
	private EditText acount_num7_value;
	private EditText acount_num8_value;
	private EditText acount_num9_value;
	private EditText acount_num10_value;
	private EditText acount_num11_value;
	private EditText acount_num12_value;
	private EditText acount_num13_value;
	private EditText acount_num14_value;
	private EditText acount_num15_value;
	private EditText acount_num16_value;

	// 19位卡号时显示
	private LinearLayout card_19;;

	private EditText acount19_num17_value;
	private EditText acount19_num18_value;
	private EditText acount19_num19_value;

	// 转换成字符串 数字
	private char[] number_array;

	public BankCardinputView(Context context, AttributeSet attrs,
							 int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);

	}

	public BankCardinputView(Context context, AttributeSet attrs, int defStyle) {

		super(context, attrs, defStyle);
		TypedArray arr = context.obtainStyledAttributes(attrs,
				R.styleable.bank_card_number, defStyle, 0);

		initView(context, 0);
		inputNumber = arr.getString(R.styleable.bank_card_number_card_number);
		cardType = arr.getString(R.styleable.bank_card_number_card_type);

		if (inputNumber != null) {

			if (!inputNumber.trim().equals("")) {

				fillViewData(inputNumber);

			}

		}

		arr.recycle();

	}

	/**
	 * 描述:填充数字 </br> 开发人员：weiyb</br> 创建时间：2015-7-28</br>
	 *
	 * @param inputNumber
	 */
	public boolean fillViewData(String inputNumber) {

		number_array = inputNumber.toCharArray();
		if (number_array.length >= 16) {

			acount_num1_value.setText(String.valueOf(number_array[0]));
			acount_num2_value.setText(String.valueOf(number_array[1]));
			acount_num3_value.setText(String.valueOf(number_array[2]));
			acount_num4_value.setText(String.valueOf(number_array[3]));
			acount_num5_value.setText(String.valueOf(number_array[4]));
			acount_num6_value.setText(String.valueOf(number_array[5]));
			acount_num7_value.setText(String.valueOf(number_array[6]));
			acount_num8_value.setText(String.valueOf(number_array[7]));
			acount_num9_value.setText(String.valueOf(number_array[8]));
			acount_num10_value.setText(String.valueOf(number_array[9]));
			acount_num11_value.setText(String.valueOf(number_array[10]));
			acount_num12_value.setText(String.valueOf(number_array[11]));
			acount_num13_value.setText(String.valueOf(number_array[12]));
			acount_num14_value.setText(String.valueOf(number_array[13]));
			acount_num15_value.setText(String.valueOf(number_array[14]));
			acount_num16_value.setText(String.valueOf(number_array[15]));
			if (number_array.length >= 19) {
				// 19位的
				acount19_num17_value.setText(String.valueOf(number_array[16]));
				acount19_num18_value.setText(String.valueOf(number_array[17]));
				acount19_num19_value.setText(String.valueOf(number_array[18]));
			}

			return true;
		} else {
			// 如果不够16位 不填充
			return false;
		}

	}

	public BankCardinputView(Context context, AttributeSet attrs) {
		// super(context, attrs);
		this(context, attrs, 0);

	}

	public BankCardinputView(Context context) {
		super(context);

		initView(context, 0);

	}

	private void initView(Context context, int type) {

		View view;

		if (type == 0) {
			view = View.inflate(context, R.layout.bank_card_input, this);

			initEditText(view);
		}

	}

	private void initEditText(View view) {

		acount_num1_value = (EditText) view
				.findViewById(R.id.acount_num1_value);
		acount_num2_value = (EditText) view
				.findViewById(R.id.acount_num2_value);
		acount_num3_value = (EditText) view
				.findViewById(R.id.acount_num3_value);
		acount_num4_value = (EditText) view
				.findViewById(R.id.acount_num4_value);
		acount_num5_value = (EditText) view
				.findViewById(R.id.acount_num5_value);
		acount_num6_value = (EditText) view
				.findViewById(R.id.acount_num6_value);
		acount_num7_value = (EditText) view
				.findViewById(R.id.acount_num7_value);
		acount_num8_value = (EditText) view
				.findViewById(R.id.acount_num8_value);
		acount_num9_value = (EditText) view
				.findViewById(R.id.acount_num9_value);
		acount_num10_value = (EditText) view
				.findViewById(R.id.acount_num10_value);
		acount_num11_value = (EditText) view
				.findViewById(R.id.acount_num11_value);
		acount_num12_value = (EditText) view
				.findViewById(R.id.acount_num12_value);
		acount_num13_value = (EditText) view
				.findViewById(R.id.acount_num13_value);
		acount_num14_value = (EditText) view
				.findViewById(R.id.acount_num14_value);
		acount_num15_value = (EditText) view
				.findViewById(R.id.acount_num15_value);
		acount_num16_value = (EditText) view
				.findViewById(R.id.acount_num16_value);

		// 十九位卡时显示
		card_19 = (LinearLayout) view.findViewById(R.id.card_19);

		acount19_num17_value = (EditText) view
				.findViewById(R.id.acount19_num17_value);
		acount19_num18_value = (EditText) view
				.findViewById(R.id.acount19_num18_value);
		acount19_num19_value = (EditText) view
				.findViewById(R.id.acount19_num19_value);

		setTextWacher();

	}

	/**
	 * 描述:设置输入监听 </br> 开发人员：weiyb</br> 创建时间：2015-7-28</br>
	 */
	private void setTextWacher() {

		acount_num1_value.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
									  int count) {
				if (s.length() == 1 && count == 1) {

					acount_num2_value.requestFocus();

				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
										  int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});

		acount_num2_value.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
									  int count) {
				if (s.length() == 1 && count == 1) {
					acount_num3_value.requestFocus();
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
										  int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (s.length() == 0) {
					acount_num1_value.requestFocus();
					moveCursor(acount_num1_value);
				}
			}

		});

		acount_num3_value.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
									  int count) {
				if (s.length() == 1 && count == 1) {
					acount_num4_value.requestFocus();
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
										  int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (s.length() == 0) {
					acount_num2_value.requestFocus();
					moveCursor(acount_num2_value);
				}
			}
		});

		acount_num4_value.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
									  int count) {
				if (s.length() == 1 && count == 1) {
					acount_num5_value.requestFocus();
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
										  int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (s.length() == 0) {
					acount_num3_value.requestFocus();
					moveCursor(acount_num3_value);
				}
			}
		});

		acount_num5_value.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
									  int count) {
				if (s.length() == 1 && count == 1) {
					acount_num6_value.requestFocus();
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
										  int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (s.length() == 0) {
					acount_num4_value.requestFocus();
					moveCursor(acount_num4_value);
				}
			}
		});

		acount_num6_value.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
									  int count) {
				if (s.length() == 1 && count == 1) {
					acount_num7_value.requestFocus();
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
										  int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (s.length() == 0) {
					acount_num5_value.requestFocus();
					moveCursor(acount_num5_value);
				}
			}
		});

		acount_num7_value.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
									  int count) {
				if (s.length() == 1 && count == 1) {
					acount_num8_value.requestFocus();
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
										  int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (s.length() == 0) {
					acount_num6_value.requestFocus();
					moveCursor(acount_num6_value);
				}
			}
		});

		acount_num8_value.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
									  int count) {
				if (s.length() == 1 && count == 1) {
					acount_num9_value.requestFocus();
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
										  int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (s.length() == 0) {
					acount_num7_value.requestFocus();
					moveCursor(acount_num7_value);
				}
			}
		});

		acount_num9_value.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
									  int count) {
				if (s.length() == 1 && count == 1) {
					acount_num10_value.requestFocus();
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
										  int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (s.length() == 0) {
					acount_num8_value.requestFocus();
					moveCursor(acount_num8_value);
				}
			}
		});

		acount_num10_value.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
									  int count) {
				if (s.length() == 1 && count == 1) {
					acount_num11_value.requestFocus();
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
										  int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (s.length() == 0) {
					acount_num9_value.requestFocus();
					moveCursor(acount_num9_value);
				}
			}
		});

		acount_num11_value.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
									  int count) {
				if (s.length() == 1 && count == 1) {
					acount_num12_value.requestFocus();
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
										  int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (s.length() == 0) {
					acount_num10_value.requestFocus();
					moveCursor(acount_num10_value);
				}
			}
		});

		acount_num12_value.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
									  int count) {
				if (s.length() == 1 && count == 1) {
					acount_num13_value.requestFocus();
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
										  int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (s.length() == 0) {
					acount_num11_value.requestFocus();
					moveCursor(acount_num11_value);
				}
			}
		});

		acount_num13_value.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
									  int count) {
				if (s.length() == 1 && count == 1) {
					acount_num14_value.requestFocus();
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
										  int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (s.length() == 0) {
					acount_num12_value.requestFocus();
					moveCursor(acount_num12_value);
				}
			}
		});

		acount_num14_value.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
									  int count) {
				if (s.length() == 1 && count == 1) {
					acount_num15_value.requestFocus();
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
										  int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (s.length() == 0) {
					acount_num13_value.requestFocus();
					moveCursor(acount_num13_value);
				}
			}
		});

		acount_num15_value.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
									  int count) {
				if (s.length() == 1 && count == 1) {
					acount_num16_value.requestFocus();
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
										  int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (s.length() == 0) {
					acount_num14_value.requestFocus();
					moveCursor(acount_num14_value);
				}
			}
		});

		acount_num16_value.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
									  int count) {
				if (s.length() == 1 && count == 1) {
					acount19_num17_value.clearFocus();
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
										  int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (s.length() == 0) {
					acount_num15_value.requestFocus();
					moveCursor(acount_num15_value);
				}
			}
		});

		// TODO 19 位卡号

		acount19_num17_value.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
									  int count) {
				if (s.length() == 1 && count == 1) {
					acount19_num18_value.clearFocus();
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
										  int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (s.length() == 0) {
					acount_num16_value.requestFocus();
					moveCursor(acount_num16_value);
				}
			}
		});
		acount19_num18_value.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
									  int count) {
				if (s.length() == 1 && count == 1) {
					acount19_num19_value.clearFocus();
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
										  int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (s.length() == 0) {
					acount19_num17_value.requestFocus();
					moveCursor(acount19_num17_value);
				}
			}
		});
		acount19_num19_value.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
									  int count) {
				if (s.length() == 1 && count == 1) {
					// acount19_num19_value.clearFocus();
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
										  int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				if (s.length() == 0) {
					acount19_num18_value.requestFocus();
					moveCursor(acount19_num18_value);
				}
			}
		});

	}

	public String getNumber() {

		StringBuffer accountNum = new StringBuffer();

		if (!"".equals(acount_num1_value.getText().toString().trim())
				&& !"".equals(acount_num2_value.getText().toString().trim())
				&& !"".equals(acount_num3_value.getText().toString().trim())
				&& !"".equals(acount_num4_value.getText().toString().trim())
				&& !"".equals(acount_num5_value.getText().toString().trim())
				&& !"".equals(acount_num6_value.getText().toString().trim())
				&& !"".equals(acount_num7_value.getText().toString().trim())
				&& !"".equals(acount_num8_value.getText().toString().trim())
				&& !"".equals(acount_num9_value.getText().toString().trim())
				&& !"".equals(acount_num10_value.getText().toString().trim())
				&& !"".equals(acount_num11_value.getText().toString().trim())
				&& !"".equals(acount_num12_value.getText().toString().trim())
				&& !"".equals(acount_num13_value.getText().toString().trim())
				&& !"".equals(acount_num14_value.getText().toString().trim())
				&& !"".equals(acount_num15_value.getText().toString().trim())
				&& !"".equals(acount_num16_value.getText().toString().trim())) {

			accountNum.append(acount_num1_value.getText().toString().trim())
					.append(acount_num2_value.getText().toString().trim())
					.append(acount_num3_value.getText().toString().trim())
					.append(acount_num4_value.getText().toString().trim())
					.append(acount_num5_value.getText().toString().trim())
					.append(acount_num6_value.getText().toString().trim())
					.append(acount_num7_value.getText().toString().trim())
					.append(acount_num8_value.getText().toString().trim())
					.append(acount_num9_value.getText().toString().trim())
					.append(acount_num10_value.getText().toString().trim())
					.append(acount_num11_value.getText().toString().trim())
					.append(acount_num12_value.getText().toString().trim())
					.append(acount_num13_value.getText().toString().trim())
					.append(acount_num14_value.getText().toString().trim())
					.append(acount_num15_value.getText().toString().trim())
					.append(acount_num16_value.getText().toString().trim());

		}

		// 19位卡
		if ("19".equals(cardType)) {

			if (!"".equals(acount19_num17_value.getText().toString().trim())
					&& !"".equals(acount19_num18_value.getText().toString()
					.trim())
					&& !"".equals(acount19_num19_value.getText().toString()
					.trim())) {

				accountNum
						.append(acount19_num17_value.getText().toString()
								.trim())
						.append(acount19_num18_value.getText().toString()
								.trim())
						.append(acount19_num19_value.getText().toString()
								.trim());

			}

		}

		if (accountNum.length() < 1) {
			accountNum.append("");
		}

		return accountNum.toString();

	};

	private void moveCursor(EditText mEditText) {
		Editable editable = mEditText.getText();
		int len = editable.length();
		if (len > 0) {
			Selection.setSelection(editable, len);
		}
	}

}
