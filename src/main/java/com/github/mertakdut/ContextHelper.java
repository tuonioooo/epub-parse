package com.github.mertakdut;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.github.mertakdut.exception.ReadingException;

/**
 * 
 * @author Mert
 * 
 *         Includes commonly needed general methods.
 */
class ContextHelper {

	static String encodeToUtf8(String stringToEncode) throws ReadingException {

		String encodedString = null;

		try {
			encodedString = URLDecoder.decode(stringToEncode, StandardCharsets.UTF_8.name());
			encodedString = URLEncoder.encode(encodedString, StandardCharsets.UTF_8.name()).replace("+", "%20");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new ReadingException("UnsupportedEncoding while encoding, " + stringToEncode + ", : " + e.getMessage());
		}

		return encodedString;
	}

	static byte[] convertIsToByteArray(InputStream inputStream) throws IOException {

		byte[] buffer = new byte[8192];
		int bytesRead;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			output.write(buffer, 0, bytesRead);
		}

		return output.toByteArray();
	}

	static String getTextAfterCharacter(String text, char character) {

		int lastCharIndex = text.lastIndexOf(character);
		return text.substring(lastCharIndex + 1);

	}

}
