package com.somewhere.util;

/*
 * ファイル名： HolidayCalendar.java
 *
 * 処理概要：日本国祝日カレンダークラス
 * LastModify：2008 11/25
 * 群馬県太田市 ソフトウェア開発 Yamanaka
 * master@k1.wind.ne.jp
 *  
 */

//#getIndexPointに使用
import android.graphics.Point;

public class HolidayCalendar {


	//初期不変値保存 年・月
	private final int SET_YEAR;
	private final int SET_MONTH;

	//フィールド変数 年・月
	private int m_Year;
	private int m_Month;


	/**
	 * チェックする年・月で初期化。


	 * 表示用年月値を定数とする為、コンストラクタはこれひとつだけにする
	 *
	 * @param  nYear   表示年
	 * @param  nMonth  表示月
	 */
	public  HolidayCalendar(int nYear, int nMonth) throws  IllegalArgumentException {

		if(nYear > 2150)               throw new IllegalArgumentException("年度指定は2150までです！");
		if(nMonth < 1 || nMonth > 12) throw new IllegalArgumentException("月指定は1-12までです！！");

		//☆表示用年月定数を有効にする
		this.m_Year = SET_YEAR = nYear;
		this.m_Month = SET_MONTH = nMonth;
	}


	/**
	 * 先月にフィールドを設定する。

	 * カレンダー表示の空白を埋めるのに一時使用メソッド
	 */
	public final void setLastMonthField() {

		//先年取得
		int pyear;
		//先月取得
		int pmon;

		if(SET_MONTH==1) {
			pyear = SET_YEAR - 1;
			pmon = 12;
		} else {
			pyear = SET_YEAR;
			pmon = SET_MONTH - 1;
		}

		this.m_Year = pyear;
		this.m_Month = pmon;

	}


	/**
	 * フィールドを初期値に戻す。

	 * カレンダー表示の空白を埋めるのに一時使用したメソッドから、元に戻す為に使う
	 * 
	 */
	public final void reSetMonthField() {

		this.m_Year = SET_YEAR;
		this.m_Month = SET_MONTH;

	}


	/**
	 * 来月にフィールドを設定する。

	 * カレンダー表示の空白を埋めるのに一時使用メソッド
	 * 
	 */
	public final void setNextMonthField() {

		//来年取得
		int nyear;
		//来月取得
		int nmon;

		if(SET_MONTH==12) {
			nyear = SET_YEAR + 1;
			nmon = 1;
		} else {
			nyear = SET_YEAR;
			nmon = SET_MONTH + 1;
		}

		this.m_Year = nyear;
		this.m_Month = nmon;

	}





	/**
	 * 祝日チェック-> 名前取り出しメソッド。

	 * 国民の祝日法は、1948年7月20日に施行される


	 * 月ごとに処理を完結する

	 * 
	 * @param nDay 検索日
	 * @return 祝日名 or 無ければnull値
	 */
	public  final String  getHolidyName(int nDay) {
		return getHolidyName(m_Year, m_Month, nDay);
	}
	public static final String  getHolidyName(int nYear, int nMonth, int nDay) {

		int nSp, nAt;

		switch(nMonth) {
	/////１月  ●1/01元日(1949開始) ●1/15成人の日(1949)/第二月曜(2000開始)      □振替休日(1973.4/12開始)
		case 1:

			//1949年から開始される
			if(nYear < 1949) break;

			// 1/01元日
			if(nDay==1) {

				return "1日元日";

			} else if(nDay==2) {

				if(getWeekIndex(nYear, nMonth, 2)==1 && nYear >= 1974) return "2日振替";

			//第二月曜日を成人の日とする
			} else if(nYear >= 2000) {


				//指定日の曜日指数(X)と、その曜日の回数(Y)
				Point p = getIndexPoint(nYear, nMonth, nDay);
				if(p.x==1 && p.y==2) return nDay + "日成人の日";


			} else {

				if(nDay==15) return "15日成人の日";
				else if(nDay==16) {
					if(getWeekIndex(nYear, nMonth, 16)==1 && nYear >= 1974) return "16日振替";
				}

			}



			break;
	/////２月  ●2/11建国記念の日(1967)       □振替休日(1973.4/12開始)
		case 2:

			if(nYear < 1967) break;

			if(nDay==11) {

				return "11日建国記念の日";

			} else if(nDay==12) {

				if(getWeekIndex(nYear, nMonth, 12)==1 && nYear >= 1974) return "12日振替";

			}

			//平成元年 1989.2/24 昭和天皇の大喪の礼



			break;
	/////３月 ●春分の日(1949)                 □振替休日(1973.4/12開始)
		case 3:

			if(nYear < 1949) break;

			nSp = koyomiSpring(nYear);

			if(nDay == nSp) {

				return nDay + "日春分の日";

			} else if(nDay==(nSp + 1)) {

				if(getWeekIndex(nYear, nMonth, nDay)==1 && nYear >= 1974) return nDay + "日振替";

			}



			break;
	/////４月 ●4/29昭和天皇誕生日(1949) /みどりの日(1989) /昭和の日((2007)  □振替休日(1973.4/12開始)
		case 4:

			if(nYear < 1949) break;

			if(nDay==29) {

				if(nYear >= 2007) {

					return "29日昭和の日";

				} else if(nYear >= 1989) {

					return "29日みどりの日";

				} else {

					return "29日天皇誕生日";

				}

			} else if(nDay==30) {

				if(getWeekIndex(nYear, nMonth, 30)==1 && nYear >= 1973) return "30日振替";

			}


			//昭和34年 1959.4/10 皇太子明仁親王の結婚の儀


			break;
	//５月 ●5/03憲法記念日(1949)  ●5/04国民の祝日(1986)みどりの日(2007)  ●5/05こどもの日(1949)  □振替休日(1973.4/12開始)
		case 5:

			if(nYear < 1949) break;

			if(nDay==3) {

				return "3日憲法記念日";

			} else if(nDay==4) {

				if(nYear>=2007) {

					return "4日みどりの日";

				} else if(nYear >= 1973) {

					if(getWeekIndex(nYear, nMonth, 4)==1) {//憲法記念日の振替休日

						return "4日振替";

					} else if(getWeekIndex(nYear, nMonth, 4)!=0 && nYear>=1986) {//日曜日は、ただの日曜日

						return "4日(国民の休日)";

					}
				}

			} else if(nDay==5) {

				return "5日こどもの日";

			} else if(nDay==6) {

				//曜日指数
				int i_week = getWeekIndex(nYear, nMonth, 6);

				if(i_week==1 && nYear >= 1973) { //5日の振替休日

					return "6日振替";

				} else if(nYear >= 2007) {  //駄目押し振替休日

					if(i_week==2 || i_week==3) return "6日振替";

				}

			}



		//break;
	/////６月
		//case 6:

			//平成5年 1993.6/09 皇太子徳仁親王の結婚の儀


			break;
	/////７月 ●7/20海の日(1996開始) /第三月曜(2003開始)                 □振替休日(1973.4/12開始)
		case 7:

			if(nYear < 1996) break;

			if(nYear >= 2003) {

				//指定日の曜日指数(X)と、その曜日の回数(Y)
				Point p = getIndexPoint(nYear, nMonth, nDay);
				if(p.x==1 && p.y==3)  return nDay + "日海の日";

			} else {

				if(nDay==20)  return "20日海の日";
				if(nDay==21 && getWeekIndex(nYear, nMonth, 21)==1) return "21日振替";

			}




			break;
	/////９月 ●9/15敬老の日(1966開始) /第三月曜(2003開始) ●秋分の日(1948開始)     □振替休日(1973.4/12開始)
		case 9:

			if(nYear < 1948) break;

			nAt = koyomiAutumn(nYear);

			if(nDay == nAt) {

				return nDay + "日秋分の日";

			} else if(nDay==(nAt + 1)) {

				if(getWeekIndex(nYear, nMonth, nDay)==1 && nYear >= 1973) return nDay + "日振替";


			} else if(nYear >= 2003) {

				//指定日の曜日指数(X)と、その曜日の回数(Y)
				Point p = getIndexPoint(nYear, nMonth, nDay);
				if(p.x==1 && p.y==3)  return nDay + "日敬老の日";

				//秋分の日の前日　（火曜で前日が敬老の日なら国民の休日になる）
				if(nDay==(nAt-1) && getWeekIndex(nYear, nMonth, nDay)==2) {

					//前日検査（秋分の日の二日前）
					p = getIndexPoint(nYear, nMonth, nDay-1);
					if(p.x==1 && p.y==3) return nDay + "日(国民の休日)";

				}

			} else if(nYear >= 1966) {

				if(nDay==15)  return "15日敬老の日";
				if(nDay==16) {
					if(getWeekIndex(nYear, nMonth, 16)==1 && nYear >= 1973) return "16日振替";
				}

			}


			break;
	/////１０月 ●体育の日(1966開始) /第二月曜(2000開始)               □振替休日(1973.4/12開始)
		case 10:

			if(nYear < 1966) break;

			if(nYear >= 2000) {

				//指定日の曜日指数(X)と、その曜日の回数(Y)
				Point p = getIndexPoint(nYear, nMonth, nDay);
				if(p.x==1 && p.y==2)  return nDay + "日体育の日";

			} else {

				if(nDay==10)  return "10日体育の日";
				if(nDay==11) {
					if(getWeekIndex(nYear, nMonth, 11)==1 && nYear >= 1973) return "11日振替";
				}

			}



			break;
	/////１１月 ●11/03文化の日(1948)  ●11/23勤労感謝の日(1948)                 □振替休日(1973.4/12開始)
		case 11:

			if(nYear < 1948) break;

			if(nDay == 3) {

				return "3日文化の日";

			} else if(nDay == 4) {

				if(getWeekIndex(nYear, nMonth, 4)==1 && nYear >= 1973) return "4日振替";

			} else if(nDay == 23) {

				return "23日勤労感謝の日";

			} else if(nDay == 24) {

				if(getWeekIndex(nYear, nMonth, 24)==1 && nYear >= 1973) return "24日振替";

			}


			//平成2年 1990.11/12 即位礼正殿の儀


			break;
	/////１２月 ●12/23天皇誕生日(1989)               □振替休日(1973.4/12開始)
		case 12:

			if(nYear < 1989) break;

			//4/29日の昭和天皇誕生日は、みどりの日に切り替わる

			if(nDay == 23) return "23日天皇誕生日";
			if(nDay == 24) {
				if(getWeekIndex(nYear, nMonth, 24)==1) return "24日振替";
			}


			break;
		}// end switch(1月～12月検索)


		return null;

	}// end method  getHolidyName(int nYear, int nMonth, int nDay)




	/**
	 * 春分の日取得
	 * @return 春分の日
	 */
	public final int koyomiSpring () {
		return koyomiSpringAutumn (m_Year, 3);
	}

	/**
	 * 春分の日取得
	 * @param nYear 検索年度
	 * @return 春分の日
	 */
	public static final int koyomiSpring (int nYear) {
		return koyomiSpringAutumn (nYear, 3);
	}

	/**
	 * 秋分の日取得
	 * @return 秋分の日
	 */
	public final int koyomiAutumn () {
		return koyomiSpringAutumn (m_Year, 9);
	}

	/**
	 * 秋分の日取得
	 * @param nYear 検索年度
	 * @return 秋分の日
	 */
	public static final int koyomiAutumn (int nYear) {
		return koyomiSpringAutumn (nYear, 9);
	}

	/**
	 * 処理：春分の日,秋分の日の計算 関数。

	 * @param nYear   年
	 * @param nMonth  月
	 * @return 取得日(1851-2150年 && 3||9月以外は, 0を出力)
	 */
	public static final int koyomiSpringAutumn (int nYear, int nMonth)  {

		if(nMonth!=3 && nMonth!=9) return 0;

		float[] Spring = {19.8277f, 20.8357f, 20.8431f, 21.8510f};
		float[] Autumn = {22.2588f, 23.2588f, 23.2488f, 24.2488f};

		int pt=0, baseY=0; 

		if (nYear >= 1851 && nYear < 1900) { pt = 0; baseY = 1983;}
		else if (nYear >= 1900 && nYear < 1980) { pt = 1; baseY = 1983;}
		else if (nYear >= 1980 && nYear < 2100) { pt = 2; baseY = 1980;}
		else if (nYear >= 2100 && nYear <= 2150){ pt = 3; baseY = 1980;}
		else {
			return 0;
		}

		int divide = (nYear - baseY) / 4;

		int getday=0;

		if (nMonth == 3) {
  			getday = (int)(Spring[pt] + 0.242194 * (nYear - 1980) - divide);
		} else if (nMonth == 9) {
  			getday = (int)(Autumn[pt] + 0.242194 * (nYear - 1980) - divide);
		}

		return getday;

	} // koyomiSpringAutume()







	/**
	 * 処理１： 月末日を取得。

	 * @return 月末日
	 */
	public final int getMonthEnd_Day() {
		return getMonthEnd_Day(m_Year, m_Month);
	}

	/**
	 * 処理２： 月末日を取得。

	 * @param  nYear 年
	 * @param  nMon  月
	 * @return  月末日
	 */
	public static final int getMonthEnd_Day(int nYear, int nMon) {

		int[] MonthEnd = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		if( ((nYear % 4 == 0 ) && (nYear % 100 != 0)) || (nYear % 400 == 0) ){
			MonthEnd[2] = 29;
		} 

		return MonthEnd[nMon];

	}






	/**
	 * 指定した日の曜日指数と、その月で何回目か出力する。

	 * 成人の日や敬老の日などに使う

	 *  ※曜日指数  0日曜日 ～ 6土曜日 

	 *
	 * @param nDay 指定日
	 * @return 指定日の曜日指数(X)と、その曜日の回数(Y)
	 */
	public final Point getIndexPoint(int nDay) {
		return getIndexPoint(m_Year, m_Month, nDay);
	}

	/**
	 * 指定した日の曜日指数と、その月で何回目か出力する。
	 *  ※曜日指数  0日曜日 ～ 6土曜日 

	 * 
	 * @param nYear  年
	 * @param nMon   月
	 * @param nDay   日
	 * @return 指定日の曜日指数(X)と、その曜日の回数(Y)
	 */
	public static final Point getIndexPoint(int nYear, int nMon, int nDay) {

		int x = getWeekIndex(nYear, nMon, nDay);
		int y = (nDay-1) / 7  + 1;

		return new Point(x, y);

	}






	/**
	 * 検索日の曜日指数を出力する。 

	 *  ※曜日指数  0日曜日 ～ 6土曜日 

	 *
	 * @param nDay 指定日
	 * @return 曜日指数
	 */
	public final int getWeekIndex(int nDay) {
		return getWeekIndex(m_Year, m_Month, nDay);
	}


	/**
	 * 検索日の曜日指数を出力する。 

	 *  ※曜日指数  0日曜日 ～ 6土曜日 

	 *
	 * @param nYear 指定年
	 * @param nMon  月
	 * @param nDay  日
	 * @return 曜日指数
	 */
	public static final int getWeekIndex(int nYear, int nMon, int nDay) {

		//1月または2月の場合は前年の13月および14月とみなす
		if(nMon <= 2) {
			nYear--;
			nMon += 12;
		}

		int set1 = nYear / 4;
		int set2 = nYear / 100;
		int set3 = nYear / 400;
		int set4 = (13 * nMon + 8) / 5;

		return (nYear + set1 - set2 + set3 + set4 + nDay) % 7;

	}




	/**
	 * 検索日の曜日指数を出す(年月に関係なしに算数計算)。

	 *  ※曜日指数  0日曜日 ～ 6土曜日 

	 *
	 * @param SET_DAY     日付
	 * @param SET_WEEK    日付の曜日指数
	 * @param search_Day  検索日
	 * @return 曜日指数
	 */
	public static final int getWeekChoice(int SET_DAY, int SET_WEEK, int search_Day) {

		int n = (search_Day - SET_DAY) * -1;
		return SET_WEEK - (n % 7);

	}

	/**
	 * 検索日の曜日指数を出す(年月に関係なしに算数計算)。

	 *  ※曜日指数  0日曜日 ～ 6土曜日 

	 *
	 * @param START_WEEK   一日の曜日指数
	 * @param search_Day   検索日
	 * @return 曜日指数
	 */
	public static final int getWeekChoice(int START_WEEK, int search_Day) {

		return (START_WEEK + search_Day - 1) % 7;

	}




	/**
	 * 総行数を算出。 

	 * 
	 * @return 総行数 (4|5|6)
	 */
	public  final int getRowCount(){
		return getRowCount(m_Year, m_Month);
	}

	/**
	 * 総行数を算出。 

	 * 
	 * @param nYear  年
	 * @param nMon   月
	 * @return 総行数 (4|5|6)
	 */
	public  static final int getRowCount(int nYear, int nMon){

		int st_week = getWeekIndex(nYear, nMon, 1); 
		int endDay = getMonthEnd_Day(nYear, nMon);


		int result = 5;

		switch(st_week) {

		 case 0:
			if(endDay < 29) result = 4;

			break;
		 case 5:
			if(endDay > 30) result =  6;

			break;
		 case 6:
			if(endDay > 29) result =  6;

		}//end switch

		return result;

	}







} //end class



