package com.hello;

public class DemoRandom {

    public static void main(String[] args) throws IOException {
        System.out.println("test");


        System.out.println("test" + new Date());

        System.out.println();

        test();

        //test_file_r_m_c_l();
        //test_file_r_l_c_m();




    }
    public static void test() {


        int[] arr = {-1, 1};

        Random random = new Random();
        for (int j = 0; j < 100; j++) {
            System.out.println(arr[random.nextInt(2)]);
        }
    }

    public static void test_file_r_m_c_l() throws IOException {

        File file = new File("/Users/hiahia/Downloads/test_file_r_m_c_l.csv");
        if (!file.exists()) {
            file.createNewFile();
        }
        OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(file));
        BufferedWriter writer = new BufferedWriter(write);

        int[] arr = {-1, 1};


        int row = 5000000;
        //int row = 5;

        int column = 6;



        // 标题行
        StringBuilder title = new StringBuilder();
        title.append("lable").append(",");
        for (int i = 0; i < column - 2; i++) {
            title.append("c" + i).append(",");
        }
        title.append("c" + (column - 1)).append("\r\n");

        writer.write(title.toString());
        writer.flush();

        // 数据行
        Random random = new Random();
        for (int i = 0; i < row; i++){
            StringBuilder sb = new StringBuilder();

            int lable = random.nextInt(6);
            sb.append(lable).append(",");

            float f = random.nextFloat()*10000*arr[random.nextInt(2)];
            String str_f = new DecimalFormat("0.00").format(f);
            sb.append(str_f).append(",");

            double d = random.nextDouble()*1000*arr[random.nextInt(2)];
            String str_d = new DecimalFormat("0.000").format(d);
            sb.append(str_d).append(",");


            sb.append(random.nextInt(1000000)*arr[random.nextInt(2)]).append(",");

            sb.append(new DecimalFormat("0.00").format(random.nextFloat()*10000*arr[random.nextInt(2)])).append(",");

            sb.append(new DecimalFormat("0.00").format(random.nextDouble()*10000*arr[random.nextInt(2)]));

            sb.append("\r\n");

            //System.out.println(sb.toString());

            writer.write(sb.toString());
            writer.flush();
        }

        write.close();
        writer.close();


        System.out.println("finish");

    }



    public static void test_file_r_l_c_m() throws IOException {

        File file = new File("/Users/hiahia/Downloads/test_file_r_l_c_m.csv");
        if (!file.exists()) {
            file.createNewFile();
        }
        OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(file));
        BufferedWriter writer = new BufferedWriter(write);

        int[] arr = {-1, 1};

        int row = 100100;
        int column = 300;

        //int row = 5;
        //int column = 10;




        // 标题行
        StringBuilder title = new StringBuilder();
        title.append("lable").append(",");
        for (int i = 0; i < column - 2; i++) {
            title.append("c" + i).append(",");
        }
        title.append("c" + (column - 1)).append("\r\n");

        writer.write(title.toString());
        writer.flush();



        Random random = new Random();
        for (int i = 0; i < row; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(random.nextInt(6)).append(",");

            for (int j = 1; j < column; j++){
                if (j % 3 == 0){
                    sb.append(random.nextInt(1000*arr[random.nextInt(2)]));
                }

                if (j % 3 == 1){
                    sb.append(new DecimalFormat("0.00").format(random.nextFloat()*10000*arr[random.nextInt(2)]));
                }

                if (j % 3 == 2){
                    sb.append(new DecimalFormat("0.000").format(random.nextDouble()*1000*arr[random.nextInt(2)]));
                }

                if (j != (column - 1)){
                    sb.append(",");
                }

            }

            sb.append("\r\n");

            System.out.println(sb.toString());

            writer.write(sb.toString());
            writer.flush();
        }

        write.close();
        writer.close();


        System.out.println("finish");

    }





}