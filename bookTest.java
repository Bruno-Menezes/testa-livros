package teste;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class bookTest {


    @Test
    public void testbooks() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bruno\\Desktop\\testeLivros\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

        //Abre o site submarino, acessa categoria livros e clica no primeiro livro
         driver.get("https://www.submarino.com.br/?opn=AFLACOM&franq=AFL-03-232373&epar=b2wafiliados");
         driver.findElement(By.linkText("Livros")).click();
         List<WebElement> allBooks = driver.findElements(By.cssSelector(".card-product-name"));
         String nomebook = allBooks.get(0).getText();

         driver.findElement(By.className("card-product-url")).click();

         driver.navigate().refresh();


         //Pesquisa pelo ISBN do livro
          List <WebElement> searchIsbnandAutor = driver.findElements(By.cssSelector(".Td-sc-1wy23hs-5.ljIgLj"));
          WebElement ISBN = searchIsbnandAutor.get(25);
          String textoISBN = (ISBN.getText());

          //Pesquisa pelo autor do Livro
          WebElement bookAutor = searchIsbnandAutor.get(27);
          String textoautor = (bookAutor.getText());

          //Preço
          WebElement preço1 = driver.findElement(By.cssSelector(".sales-price.main-offer__SalesPrice-sc-1oo1w8r-1.fiWaea.TextUI-sc-12tokcy-0.dsOSmW"));
          String preço1string = preço1.getText();

        //Procura pelo primeiro site com o livro
         System.setProperty("webdriver.chrome.driver", "C:\\Users\\bruno\\Desktop\\testeLivros\\Drivers\\chromedriver.exe");
         WebDriver driver1 = new ChromeDriver();
         driver1.manage().window().maximize();
         driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

         driver1.get("https://www.americanas.com.br/");
         driver1.findElement(By.className("src-input")).sendKeys(" " + nomebook);
         driver1.findElement(By.cssSelector(".src-btn")).click();
         driver1.findElement(By.cssSelector(".SectionUI-bwhjk3-3.hcnsuQ.ViewSection-sc-1ijittn-2.jMrcKt")).click();

         //Procura pelo autor e ISBN no site
         driver.navigate().refresh();
         List <WebElement> booktwo = driver1.findElements(By.cssSelector(".Td-sc-1wy23hs-5.ljIgLj"));
         WebElement bookautortwo = booktwo.get(27);
         String textoautor1 = (bookautortwo.getText());

         driver.navigate().refresh();
         List <WebElement> booktwo1 = driver1.findElements(By.cssSelector(".Td-sc-1wy23hs-5.ljIgLj"));
         WebElement isbnTwo = booktwo1.get(25);
         String textoISBN1 = (isbnTwo.getText());


         // Procura pelo preço
         WebElement preço2 = driver1.findElement(By.cssSelector(".sales-price.main-offer__SalesPrice-sc-1oo1w8r-1.haZIvY.TextUI-sc-12tokcy-0.cwbgyz"));
         String preço2string = preço2.getText();


         //Procura pelo segundo site com o livro
         System.setProperty("webdriver.chrome.driver", "C:\\Users\\bruno\\Desktop\\testeLivros\\Drivers\\chromedriver.exe");
         WebDriver driver2 = new ChromeDriver();
         driver2.manage().window().maximize();
         driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

         driver2.get("https://www.shoptime.com.br");
         WebElement searchlivraria = driver2.findElement(By.className("src-input"));
         searchlivraria.sendKeys("livro a sutil arte de ligar o fodase");
         driver2.findElement(By.className("src-btn")).click();
         driver2.findElement(By.className("card-product-details")).click();

         //Procura pelo autor e ISBN
         List <WebElement> searchIsbnandAutor2 = driver2.findElements(By.cssSelector(".Td-sc-1wy23hs-5.ljIgLj"));
         WebElement Isbn = searchIsbnandAutor2.get(7);
         String textoISBN2 = (Isbn.getText());
         WebElement autor2 = searchIsbnandAutor2.get(5);
         String textoautor2 = autor2.getText();

         // Procura pelo nome do livro
         WebElement bookname = driver2.findElement(By.cssSelector(".product-title__TitleUI-sc-116vf1e-2.bDZZCj.TitleH1-sc-1wh9e1x-0.fpuWQw"));
         String textobookname2 = bookname.getText();

         // Procura pelo preço
         WebElement preçobook2 = driver2.findElement(By.cssSelector(".sales-price.main-offer__SalesPrice-sc-1oo1w8r-1.kdqTlB.TextUI-sc-12tokcy-0.haPmlF"));
         String preço3string = preçobook2.getText();


        // Texto
        System.out.println("Nome do primeiro livro encontrado: " + nomebook);
        System.out.println("ISBN: " + textoISBN);
        System.out.println("Autor: " + textoautor);
        System.out.println("Preço: " + preço1string);
        System.out.println("---------------------------------------------------------");

        System.out.println("Nome do segundo livro encontrado: " + nomebook);
        System.out.println("ISBN: " + textoISBN1);
        System.out.println("Autor: " + textoautor1);
        System.out.println("Preço: " + preço2string);
        System.out.println("---------------------------------------------------------");

        System.out.println("Nome do segundo livro encontrado: " + textobookname2);
        System.out.println("ISBN: " + textoISBN2);
        System.out.println("Autor: " + textoautor2);
        System.out.println("Preço: " + preço3string);
        System.out.println("---------------------------------------------------------");

        //Me diz se o segundo livro é igual o primeiro

        System.out.println("Compara o segundo livro com primeiro: ");
        System.out.println("Segundo ISBN é igual o primeiro: ");
        if (textoISBN.toLowerCase().contentEquals(textoISBN1)){
            System.out.println("Verdade");
        } else {
      System.out.println("Falso");
        }

        System.out.println("Segundo autor é igual o primeiro: ");
        if (textoautor.toLowerCase().contains(textoautor1.toLowerCase())){
            System.out.println("Verdade");
        } else {
            System.out.println("Falso");
        }

        //Me diz se o terceiro livro é igual o primeiro

        System.out.println("Compara o terceiro livro com primeiro: ");
        System.out.println("Segundo ISBN é igual o primeiro: ");
        if (textoISBN.toLowerCase().contentEquals(textoISBN2)){
            System.out.println("Verdade");
        } else {
            System.out.println("Falso");
        }

        System.out.println("Segundo autor é igual o primeiro: ");
        if (textoautor.toLowerCase().contains(textoautor2.toLowerCase())){
            System.out.println("Verdade");
        } else {
            System.out.println("Falso");
        }








    }
}
