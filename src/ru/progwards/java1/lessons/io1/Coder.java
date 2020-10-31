package ru.progwards.java1.lessons.io1;

//                              Начало ...-=-... Coder...-=-...
/**      жавадок =)
*        Задача 2. Класс Coder
*        Создать статический метод public static void codeFile
*        (String inFileName, String outFileName, char[] code,
*        String logName),
*        в котором прочитать файл inFileName и перекодировать его посимвольно
*        в соответствии с заданным шифром, результат записать в outFileName.
*        Шифр задается маcсивом char[] code, где каждому символу symbol
*        оригинального файла соответствует символ code[(int)symbol] выходного файла.
*        В случае ошибок, в файл с именем logName вывести название ошибки через
*        метод класса Exception - getMessage()
*/
public class Coder extends CharFilter{
     /**
      * String inFileName - путь к кодируемому файлу
      * String outFileName - путь к файлу с результатом кодирования
      * char[] code - массив символов char - код шифрования (кодовая страница, ожидаем 256 символов)
      * String logName - путь к файлу, куда будет записан лог ошибок
      */
     public static void codeFile(String inFileName, String outFileName, char[] code, String logName)  {

          System.out.println(inFileName + " - inFileName");
          System.out.println(outFileName + " - outFileName");
          System.out.println(logName + " - logName");

          String charINFO = new String(code);
          System.out.println("Длина массива символов: " + code.length);
          System.out.println("Сами символы:\n" + charINFO + "\n");
          System.out.println("Коды символов: ");
          for (int i = 0; i < code.length; i++) {
               System.out.println((int) code[i]);
          }
          // Код выше - отладочная часть (вывод в консоль аргументов ProgWards'кого робота)
          String LOG; // Текст ЛОГа
          String OUT = new String();
          try{
               String IN = read(inFileName); // Читаем файл
               System.out.println("Прочитан файл: " + inFileName + " содержимое файла:\n" + IN + "\n\"");

               int vop;
               char[] res = IN.toCharArray();
               try{
                    for (int i = 0; i < res.length; i++) { // До конца файла
                         vop = (int)res[i];// берем его символ, выясняем его код (Переводим в int)
                         OUT+=code[vop];// по найденному индексу принимаем символ из code
                    }
               }catch(Exception e){
                    System.out.println("Возникло исключение в блоке try ... catch метода coder");

                    LOG = e.getMessage(); // Если ошибка, пишем ошибку в лог
                    System.out.println(LOG);
                    write(outFileName, OUT);  // всё равно пытаемся записать файл
               }
          }catch(Exception e){
               System.out.println("Возникло исключение в блоке try ... catch метода codeFile класса coder");
               LOG = e.getMessage(); // Если ошибка, пишем ошибку в лог
               write(LOG, logName);  // И выводим лог в файл
               e.printStackTrace();
               throw new RuntimeException("Выход за пределы массива или массив не существует", e);
          }finally{
               write(outFileName, OUT);  // всё равно пытаемся записать файл
          }
     }
}
//                                конец ...-=-... Coder...-=-...