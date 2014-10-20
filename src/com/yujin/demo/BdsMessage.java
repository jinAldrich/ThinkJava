/*
 * 
 */

package com.yujin.demo;

/**
 * Definitions of the messages columns and helper functions
 * 
 * @author JYZ
 */
public final class BdsMessage {
	public static final String AUTH = "com.bw.bd.send";

	// short message
	public static final String AUTHORITY_PLUS_SHORTMESSAGE = "content://" + AUTH + "/shortMessages/";


	private interface ShortMessageColumns {

		/**
		 * FOLDER: the type of short message, 1: received from others; 2: sent
		 * to others
		 */
		public static final String FOLDER = "folder";

		/**
		 * Time for the short message sent/received
		 */
		public static final String DATE = "date";

		/**
		 * The short message's content
		 */
		public static final String CONTENT = "content";

		/**
		 * The from user ID of the received short message
		 */
		public static final String FROM_ID = "fromId";
		public static final String FROM_NAME = "fromId";
		/**
		 * The receiver user ID for the sent short message
		 */
		public static final String TO_ID = "toId";
		public static final String TO_NAME = "toId";
		/**
		 * whether the message is readed
		 */
		public static final String IS_READ = "isRead";
	}

	
}
