import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class PdfDemo {
	public static void main(String args[]) {
		//Document document = new Document();
		try {
			// Create a loop to create 25 PDF files
			for (int i = 1; i <= 25; i++) {
				// Create a Document instance
				Document document = new Document();

				// Create an OutputStream instance
				OutputStream outputStream = new FileOutputStream(
						new File("C:\\Users\\Lenovo\\Documents\\GitHub\\TestFile" + i + ".pdf"));

				// Create a PDFWriter instance
				PdfWriter.getInstance(document, outputStream);

				// Open the document
				document.open();

				// Add content to the document
				document.add(new Paragraph("java"));

				// Close the document and the output stream
				document.close();
				outputStream.close();

				System.out.println("PDF file " + i + " created successfully.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

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

				System.out.println("PDF file " + i + " created successfully.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

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

				System.out.println("PDF file " + i + " created successfully.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		{
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

					System.out.println("PDF file " + i + " created successfully.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			
			// Search & Copy function // 
			
			
			Document document = new Document();
			try  {
				
	            // Create an OutputStream instance for the new PDF file
	            OutputStream outputStream = new FileOutputStream(new File("C:\\\\Users\\\\Lenovo\\\\Documents\\\\GitHub\\\\NewFile.pdf"));
	            document.add(new Paragraph("java"));

	            // Create a PDFWriter instance for the new PDF file
	            PdfWriter.getInstance(document, outputStream);

	            // Open the document
	            document.open();
			
	            // Create a list to store the matching PDF files
	            List<PdfReader> matchingPdfs = new ArrayList<>();
 
	            // Search the created PDF files for a specific string
	            for (int i = 1; i <= 100; i++) {
	                // Create a PdfReader instance for each PDF file
	                PdfReader reader = new PdfReader("C:\\Users\\Lenovo\\Documents\\GitHub\\TestFile" + i + ".pdf");

	                // Get the number of pages in the PDF file
	                int n = reader.getNumberOfPages();

	                // Loop through the pages of the PDF file
	                for (int j = 1; j <= n; j++) {
	                    // Get the page content as a string
	                    String pageContent = PdfTextExtractor.getTextFromPage(reader, j);

	                    // Check if the page content contains the search string
	                    if (pageContent.contains("java")) {
	                        // If the page content contains the search string, add the PDF file to the list of matching PDFs
	                        matchingPdfs.add(reader);
	                       break;
	                      
	                    }
	                    
	                }
	                
	            }
	            
	         // Add the matching PDF files to the new PDF file
	            for (PdfReader reader : matchingPdfs) {
	            	
	                PdfCopy copy = new PdfCopy(document, outputStream);
	                
	                document.addDocListener(copy);
	                
	               copy.addDocument(reader);
	                reader.close();
	                
	            }
	            
	         // Close the document and the output stream
	            document.close();
	            outputStream.close();

	            System.out.println("New PDF file created successfully.");
	                        
			}             
	             
			 catch (Exception e) {
		            e.printStackTrace();
		        }
	                        
	                        
	                        
			
		}
	}
	
}
