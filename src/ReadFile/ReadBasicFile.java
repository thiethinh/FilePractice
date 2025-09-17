package ReadFile;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class ReadBasicFile {
	public static void main(String[] args) throws IOException, ClassNotFoundException {

//		String path = "doc.txt";
//		try {
//			BufferedReader br = new BufferedReader(new FileReader(path));
//			String line;
//			int numb=1;
//			while ((line= br.readLine())!=null) {
//				System.out.println("Dong: "+numb+ " "+line);
//				numb++;
//			}
//			
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		try {
//			BufferedWriter bw = new BufferedWriter(new FileWriter(path,true));
//			String[] arr = new String[] {"mot","hai","ba"};
//			for(String str: arr) {
//				bw.write(str+"\n");
//			}
//			bw.close();
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		}

		try {
//			FileInputStream in = new FileInputStream("source.jpg");
//			FileOutputStream out = new FileOutputStream("copy1.jpg");
//			byte[] buffer = new byte[8192]; //8KB
//			int numbByteOfBuffer;
//			while((numbByteOfBuffer=in.read(buffer))!=-1) {
//				out.write(buffer,0,numbByteOfBuffer);
//			}
//			in.transferTo(out);

			BufferedImage bi = ImageIO.read(new File("source.jpg"));
			ImageIO.write(bi, "png", new File("cp.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		Person p1 = new Person("Nguyen van a", 20);
		Person p2 = new Person("Nguyen van b", 21);
		Person p3 = new Person("Nguyen van c", 22);
		List<Person> persons = new ArrayList<Person>();
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
//		try {
//			ObjectOutputStream ou = new ObjectOutputStream(new FileOutputStream("people.dat"));
//			ou.writeObject(persons);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}

//		try {
//			ObjectInputStream oi = new ObjectInputStream(new FileInputStream("people.dat"));
//			ArrayList<Person> loaded = (ArrayList<Person>) oi.readObject();
//			for (Person person : loaded) {
//				System.out.println(person.toString());
//			}
//			
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		}

		// xoay anh

//		BufferedImage original = ImageIO.read(new File("source.jpg"));
//		BufferedImage rotated = rotateImg(original, 45);
//		ImageIO.write(rotated, "jpg", new File("rotated.jpg"));
//		System.out.println("Đã xoay ảnh và lưu thành công!");

		try {
			InputStream inputAuido = new FileInputStream(new File("love.mp3"));
			byte[] allFile = inputAuido.readAllBytes();
			System.out.println("Đọc: " + allFile.length + " byte");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		try {
			File file = new File("love.wav");
			AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
			Thread.sleep(clip.getMicrosecondLength() / 1000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static BufferedImage rotateImg(BufferedImage bi, double angle) {
		double radians = Math.toRadians(angle);
		double sin = Math.abs(Math.sin(radians));
		double cos = Math.abs(Math.cos(radians));
		int w = bi.getWidth();
		int h = bi.getHeight();

		int newW = (int) Math.floor(w * cos + h * sin);
		int newH = (int) Math.floor(w * cos + h * sin);

		BufferedImage rotated = new BufferedImage(newW, newH, bi.getType());
		Graphics2D g2d = rotated.createGraphics();

		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

		// Tịnh tiến để tâm ảnh nằm giữa
		AffineTransform at = new AffineTransform();
		at.translate((newW - w) / 2.0, (newH - h) / 2.0);

		at.rotate(radians, w / 2.0, h / 2.0);
		g2d.drawRenderedImage(bi, at);
		g2d.dispose();
		return rotated;
	}
}
