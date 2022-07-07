package com.lec.ex1_string;
public class Ex05_regex {
	public static void main(String[] args) {
		//System.out.println("replace =>" + str.replace("0", "È«")); // 0¸¸ È«À¸·Î ¹Ù²ñ
		/* Á¤±ÔÇ¥Çö½Ä (regex)
		 1. ÂüÁ¶ : https://goo.gl/HLntbd
		 
		 2. °£·« ¹®¹ı
		 		\d (¼ıÀÚ¿Í ¸ÅÄ¡, [0-9]¿Í µ¿ÀÏ) \D(¼ıÀÚ°¡ ¾Æ´Ñ °Í)
		 		\s (whitespacen : space, ÅÇ, ¿£ÅÍ)
		 		\w (¿µ¹®ÀÚ³ª ¼ıÀÚ, [a-zA-Z0-9]¿Í µ¿ÀÏ) \W(¿µ¹®ÀÚ³ª ¼ıÀÚ°¡ ¾Æ´Ñ ¹®ÀÚ)
		 		. (¹®ÀÚ ÇÏ³ª)
		 		+ (1¹øÀÌ»ó ¹İº¹)
		 		* (0¹ø ÀÌ»ó ¹İº¹)
		 		? (0~1¹ø ¹İº¹)
		 		{2,4} (2~4È¸ ¹İº¹)
		 3. Á¤±ÔÇ¥Çö½Ä ¿¬½ÀÀå : https://regexr.com   https://www.regexpal.com 
		       ex. ÀüÈ­¹øÈ£ : .?[0-9]{2,3}.[0-9]{3,4}-[0-9]{4}
		                        ÀÌ¸ŞÀÏ : 
		 4. Æ¯Á¤ Á¤±ÔÇ¥Çö½ÄÀÇ ¹®ÀÚ¿­ º¯°æ : replaceAll("Á¤±ÔÇ¥Çö½Ä" , "´ëÃ¼¹®ÀÚ¿­")         
		 */
		String str = "010-9999-9999 yisy0703@naver.com  (02)565-8888  ¹İ°©½À´Ï´Ù. ¤¾¤¾ Hello 951212-2521251 abc@sds.co.kr";
		// ÀüÈ­¹øÈ£ ÁöÃã
		System.out.println(str.replaceAll("[(]?[0-9]{2,3}\\D[0-9]{3,4}-[0-9]{4}", "** ÀüÈ­¹øÈ£ Áö¿ò **"));
		// ÀÌ¸ŞÀÏ Áö¿ò
		System.out.println(str.replaceAll("\\w+@\\w+(.\\w+){1,2}", "**ÀÌ¸ŞÀÏ Áö¿ò**"));
		// ¾ËÆÄºª ´ë½Å *·Î ´ëÃ¼
		System.out.println(str.replaceAll("[a-zA-Z]", "*"));
		// ÇÑ±Û ½Ï ´Ù ¾ø¾Ö
		System.out.println(str.replaceAll("[°¡-ÆR¤¡-¤¾]", ""));
		// ÁÖ¹Î¹øÈ£ µŞÀÚ¸®¸¦ *·Î ´ëÃ¼
		System.out.println(str.replaceAll("[0-9]{7}", "*******"));
	}
}






