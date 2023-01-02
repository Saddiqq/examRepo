import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfDemo {
	
	public static final String Green = "\u001B[92m";
	public static final String Blue = "\u001B[96m";
	public static final String White = "\033[37m";
	public static final String Black = "\u001B[30m";
	public static final String Purple = "\033[35m";
	public static final String Cyan = "\033[36m";
	public static final String Red = "\033[31m";

	public static void merge(File source, File dest) throws IOException {
		// copy file in folder
		Files.copy(source.toPath(), dest.toPath());
	}

	public static void main(String args[]) {

		try {

			/*
			 * Create a loop to create 25 PDF files, Total documents required are 100. / 4
			 * (4 Skill Types) = 25
			 */

			for (int i = 1; i <= 25; i++) {

// Create Document instance

				Document document = new Document();

// Create OutputStream instance

				OutputStream outputStream = new FileOutputStream(

						new File("C:\\Users\\Lenovo\\Documents\\GitHub\\TestFile" + i + ".pdf"));

// Create PDFWriter instance

				PdfWriter.getInstance(document, outputStream);

// Open document

				document.open();

// Add content to the document

				document.add(new Paragraph("java"));

// Close the document and the output stream

				document.close();

				outputStream.close();

				System.out.println(Green+ "PDF file " + i + " created successfully.");

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		// Repeat for skill type 2
		try {

			for (int i = 26; i <= 50; i++) {

				Document document = new Document();

				OutputStream outputStream = new FileOutputStream(

						new File("C:\\Users\\Lenovo\\Documents\\GitHub\\TestFile" + i + ".pdf"));

				PdfWriter.getInstance(document, outputStream);

				document.open();

				document.add(new Paragraph("java"));

				document.add(new Paragraph("Python"));

				document.close();

				outputStream.close();

				System.out.println(Green+ "PDF file " + i + " created successfully.");

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		// Repeat for skill type 3
		try {

			for (int i = 51; i <= 75; i++) {

				Document document = new Document();

				OutputStream outputStream = new FileOutputStream(

						new File("C:\\Users\\Lenovo\\Documents\\GitHub\\TestFile" + i + ".pdf"));

				PdfWriter.getInstance(document, outputStream);

				document.open();

				document.add(new Paragraph("java"));

				document.add(new Paragraph("Python"));

				document.add(new Paragraph("C++"));

				document.close();

				outputStream.close();

				System.out.println(Green+ "PDF file " + i + " created successfully.");

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		{
			// Repeat for skill type 4
			try {

				for (int i = 76; i <= 100; i++) {

					Document document = new Document();

					OutputStream outputStream = new FileOutputStream(

							new File("C:\\Users\\Lenovo\\Documents\\GitHub\\TestFile" + i + ".pdf"));

					PdfWriter.getInstance(document, outputStream);

					document.open();

					document.add(new Paragraph("java"));

					document.add(new Paragraph("Python"));

					document.add(new Paragraph("C++"));

					document.add(new Paragraph("SQL"));

					document.close();

					outputStream.close();

					System.out.println(Green+ "PDF file " + i + " created successfully.");

				}

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

		// Search & Copy Method

		// Initialize Scanner
		Scanner sc = new Scanner(System.in);
		try {
			// Create a list to store the PDF files that contain the Search Word
			List<String> matchedPdfFiles = new ArrayList<>();
			System.out.println(Blue+ "\n \n \n Enter The Desired Search Word:");
			String searchWord = sc.next();
			// Go through all the PDF files created previously
			for (int i = 1; i <= 100; i++) {
				// Read the PDF file
				PdfReader reader = new PdfReader("C:\\Users\\Lenovo\\Documents\\GitHub\\TestFile" + i + ".pdf");
				// Extract the text from the PDF file
				String text = PdfTextExtractor.getTextFromPage(reader, 1);
				// Check if the PDF file contains the text Search Word
				if (text.contains(searchWord)) {
					// If the PDF file contains the text Search Word, add it to the list of matched PDF files
					matchedPdfFiles.add("C:\\Users\\Lenovo\\Documents\\GitHub\\TestFile" + i + ".pdf");

				} else {
					System.out.println(Red+ "Search Word  (" + searchWord + ")  Not Found in Document No." + i + ".pdf");
				}

				// Close the PDF reader
				reader.close();
			}

			// GO through the list of matched PDF files
			for (String matchedPdfFile : matchedPdfFiles) {
				// Get the file name of the matched PDF file
				String fileName = matchedPdfFile.substring(matchedPdfFile.lastIndexOf("\\") + 1);

				// Create a new PDF document
				Document document = new Document();

				// Create an OutputStream for the PDF file to be copied to
				OutputStream outputStream = new FileOutputStream(
						new File("C:\\Users\\Lenovo\\Documents\\GitHub\\copylocation\\" + fileName));

				// Create a PDF copy
				PdfCopy copy = new PdfCopy(document, outputStream);

				// Open the PDF document
				document.open();

				// Add the pages of the matched PDF file to the new PDF document
				PdfReader reader = new PdfReader(matchedPdfFile);
				copy.addDocument(reader);

				// Close the PDF reader and document
				reader.close();
				document.close();

				// Close the OutputStream
				outputStream.close();

				System.out.println(Green+ "PDF file " + fileName + " copied successfully.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}