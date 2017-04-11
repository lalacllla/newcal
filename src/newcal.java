import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/4/11.
 */
public class newcal {



    public static double all;
    public static double right;
    public static void main(String[] args) {
        int i=0;
        all=0;
        right=0;
        System.out.print("HINT:含有分数的四则运算的结果请用分数表达(除非结果刚好为整数)\n");
        System.out.print("以分数表达的时候请化简为最简形式\n");
        System.out.print("输入quit退出\n");
        while(i==0)
            i=create();
    }

    public static int create() {
        java.util.Random r = new java.util.Random();
        int iszrs ,reply=0;
        int temp;
        String S;

        temp=r.nextInt(3)+1;
        S=createsymbol();
        if(temp==1)
        {
            reply=cal(S,temp);
        }
        if(temp==2)
        {
            reply=cal(S,temp);
        }
        if(temp==3)
        {
            reply=cal(S,temp);
        }
        if(temp==4)
        {
            reply=cal(S,temp);
        }
        all++;
        DecimalFormat df = new DecimalFormat("0.00%");
        if(reply==1)
        {
            right++;
            System.out.print("答对啦,一共有"+(int)all+"道题,答对"+(int)right+"道题,正确率为"+df.format((right/all))+"\n");
        }
        else if(reply==0)
        {
            System.out.print("答错啦,一共有"+(int)all+"道题,答对"+(int)right+"道题,正确率为"+df.format((right/all))+"\n");
        }
        else if(reply==2) {
            return 1;
        }

        return 0;
    }
    public static int cal(String S,int i)
    {
        int fs[] = new int[2];
        int z=0,y=0,flag=0,q=0,p=0,zrs=0,f=0,g=0;
        int temp=0,temp2=0;
        double temp3;
        double x=0.0,m=0.0;
        switch (i)
        {
            case 1://整数与整数的运算
                if(S.equals("+") )
                {
                    zrs=createzrs();
                    z=zrs;
                    zrs=createzrs();
                    y=zrs;
                    f=z+y;
                }
                if(S.equals("-"))
                {
                    zrs=createzrs();
                    z=zrs;
                    zrs=createzrs();
                    y=zrs;
                    f=z-y;
                }
                if(S.equals("*"))
                {
                    zrs=createzrs();
                    z=zrs;
                    zrs=createzrs();
                    y=zrs;
                    f=z*y;
                }
                if(S.equals("/"))
                {
                    zrs=createzrs();
                    z=zrs;
                    zrs=createzrs();
                    y=zrs;
                    f=z;
                    g=y;
                    //x=(double)z/(double)y;
                }
                System.out.print(z+" "+S+" "+y+" =");
                break;
            case 2://整数与分数的运算，整数在前
                if(S.equals("+"))
                {
                    zrs=createzrs();
                    z=zrs;
                    fs=createfs();
                    f=z*fs[1]+fs[0];
                    g=fs[1];
                   // x=(double)fs[0]/(double)fs[1];
                }
                if(S.equals("-"))
                {
                    zrs=createzrs();
                    z=zrs;
                    fs=createfs();
                    f=z*fs[1]-fs[0];
                    g=fs[1];
                }
                if(S.equals("*"))
                {
                    zrs=createzrs();
                    z=zrs;
                    fs=createfs();
                    f=z*fs[0];
                    g=fs[1];
                }
                if(S.equals("/"))
                {
                    zrs=createzrs();
                    z=zrs;
                    fs=createfs();
                    y=fs[0];
                    f=z*fs[1];
                    g=fs[0];
                }
                System.out.print(z+" "+S+" "+fs[0]+"/"+fs[1]+" =");
                break;
            case 3://整数与分数的运算，整数在后
                if(S.equals("+"))
                {
                    zrs=createzrs();
                    z=zrs;
                    fs=createfs();
                    f=z*fs[1]+fs[0];
                    g=fs[1];
                }
                if(S.equals("-"))
                {
                    zrs=createzrs();
                    z=zrs;
                    fs=createfs();
                    f=fs[0]-(z*fs[1]);
                    g=fs[1];
                }
                if(S.equals("*"))
                {
                    zrs=createzrs();
                    z=zrs;
                    fs=createfs();
                    f=z*fs[0];
                    g=fs[1];
                }
                if(S.equals("/"))
                {
                    zrs=createzrs();
                    z=zrs;
                    fs=createfs();
                    f=fs[0];
                    g=z*fs[1];
                }
                System.out.print(fs[0]+"/"+fs[1]+" "+S+" "+z+" =");
                break;
            case 4://分数与分数的运算
                if(S.equals("+"))
                {
                    fs=createfs();
                    z=fs[0];//a
                    y=fs[1];//b
                    fs=createfs();
                    q=fs[0];//d
                    p=fs[1];//c
                    f=(p*y+q*z)/simplify(y,p);
                    g=(z*p)/simplify(y,p);
                }
                if(S.equals("-"))
                {
                    fs=createfs();
                    z=fs[0];
                    y=fs[1];
                    fs=createfs();
                    q=fs[0];
                    p=fs[1];
                    f=(p*y-q*z)/simplify(y,p);
                    g=(z*p)/simplify(y,p);
                }
                if(S.equals("*"))
                {
                    fs=createfs();
                    z=fs[0];
                    y=fs[1];
                    fs=createfs();
                    q=fs[0];
                    p=fs[1];
                    f=z*q;
                    g=y*p;
                }
                if(S.equals("/"))
                {
                    fs=createfs();
                    z=fs[0];
                    y=fs[1];
                    fs=createfs();
                    q=fs[0];
                    p=fs[1];
                    f=z*p;
                    g=y*q;
                }
                System.out.print(z+"/"+y+" "+S+" "+q+"/"+p+" =");
                 break;
        }
        System.out.print(" 请输入答案:");
        Scanner xx = new Scanner(System.in);
        String text[]= new String[10];
        String str = xx.nextLine();
        if(str.equals("quit"))
        {

            return 2;
        }
        switch(i)
        {
            case 1:
                if(S.equals("+"))
                {
                    temp = Integer.parseInt(str);
                    if(temp == f)
                        flag = 1;
                }
                if(S.equals("-"))
                {
                    temp = Integer.parseInt(str);
                    if(temp == f)
                        flag = 1;
                }
                if(S.equals("*"))
                {
                    temp = Integer.parseInt(str);
                    if(temp == f)
                        flag = 1;
                }
                if(S.equals("/"))
                {
                    if(str.contains("/")) {//数据类型为分数
                        text = str.split("/");
                        temp = Integer.parseInt(text[0]);
                        temp2 = Integer.parseInt(text[1]);
                        f=f/simplify(f,g);
                        g=g/simplify(f,g);
                        if(temp == f&&temp2 == g)
                            flag = 1;
                    }
                    else
                    {
                        f=f/simplify(f,g);
                        if(f==Integer.parseInt(str))
                            flag = 1;
                    }
                }break;
            case 2://整数与分数的运算，整数在前
                if(S.equals("+"))
                {
                    if(str.contains("/")) {//数据类型为分数
                        text = str.split("/");
                        temp = Integer.parseInt(text[0]);
                        temp2 = Integer.parseInt(text[1]);
                        f=f/simplify(f,g);
                        g=g/simplify(f,g);
                        if(temp == f&&temp2 == g)
                            flag = 1;
                    }
                    else
                    {
                        f=f/simplify(f,g);
                        if(f==Integer.parseInt(str))
                            flag = 1;
                    }
                }
                if(S.equals("-"))
                {
                    if(str.contains("/")) {//数据类型为分数
                        text = str.split("/");
                        temp = Integer.parseInt(text[0]);
                        temp2 = Integer.parseInt(text[1]);
                        f=f/simplify(f,g);
                        g=g/simplify(f,g);
                        if(temp == f&&temp2 == g)
                            flag = 1;
                    }
                    else
                    {
                        f=f/simplify(f,g);
                        if(f==Integer.parseInt(str))
                            flag = 1;
                    }
                }
                if(S.equals("*"))
                {
                    if(str.contains("/")) {//数据类型为分数
                        text = str.split("/");
                        temp = Integer.parseInt(text[0]);
                        temp2 = Integer.parseInt(text[1]);
                        f=f/simplify(f,g);
                        g=g/simplify(f,g);
                        if(temp == f&&temp2 == g)
                            flag = 1;
                    }
                    else
                    {
                        f=f/simplify(f,g);
                        if(f==Integer.parseInt(str))
                            flag = 1;
                    }
                }
                if(S.equals("/"))
                {
                    if(str.contains("/")) {//数据类型为分数
                        text = str.split("/");
                        temp = Integer.parseInt(text[0]);
                        temp2 = Integer.parseInt(text[1]);
                        f=f/simplify(f,g);
                        g=g/simplify(f,g);
                        if(temp == f&&temp2 == g)
                            flag = 1;
                    }
                    else
                    {
                        f=f/simplify(f,g);
                        if(f==Integer.parseInt(str))
                            flag = 1;
                    }
                }break;
            case 3://整数与分数的运算，整数在后
                if(S.equals("+"))
                {
                    if(str.contains("/")) {//数据类型为分数
                        text = str.split("/");
                        temp = Integer.parseInt(text[0]);
                        temp2 = Integer.parseInt(text[1]);
                        f=f/simplify(f,g);
                        g=g/simplify(f,g);
                        if(temp == f&&temp2 == g)
                            flag = 1;
                    }
                    else
                    {
                        f=f/simplify(f,g);
                        if(f==Integer.parseInt(str))
                            flag = 1;
                    }
                }
                if(S.equals("-"))
                {
                    if(str.contains("/")) {//数据类型为分数
                        text = str.split("/");
                        temp = Integer.parseInt(text[0]);
                        temp2 = Integer.parseInt(text[1]);
                        f=f/simplify(f,g);
                        g=g/simplify(f,g);
                        if(temp == f&&temp2 == g)
                            flag = 1;
                    }
                    else
                    {
                        f=f/simplify(f,g);
                        if(f==Integer.parseInt(str))
                            flag = 1;
                    }
                }
                if(S.equals("*"))
                {
                    if(str.contains("/")) {//数据类型为分数
                        text = str.split("/");
                        temp = Integer.parseInt(text[0]);
                        temp2 = Integer.parseInt(text[1]);
                        f=f/simplify(f,g);
                        g=g/simplify(f,g);
                        if(temp == f&&temp2 == g)
                            flag = 1;
                    }
                    else
                    {
                        f=f/simplify(f,g);
                        if(f==Integer.parseInt(str))
                            flag = 1;
                    }
                }
                if(S.equals("/"))
                {
                    if(str.contains("/")) {//数据类型为分数
                        text = str.split("/");
                        temp = Integer.parseInt(text[0]);
                        temp2 = Integer.parseInt(text[1]);
                        f=f/simplify(f,g);
                        g=g/simplify(f,g);
                        if(temp == f&&temp2 == g)
                            flag = 1;
                    }
                    else
                    {
                        f=f/simplify(f,g);
                        if(f==Integer.parseInt(str))
                            flag = 1;
                    }
                }break;
            case 4://分数与分数的运算
                if(S.equals("+"))
                {
                    if(str.contains("/")) {//数据类型为分数
                        text = str.split("/");
                        temp = Integer.parseInt(text[0]);
                        temp2 = Integer.parseInt(text[1]);
                        f=f/simplify(f,g);
                        g=g/simplify(f,g);
                        if(temp == f&&temp2 == g)
                            flag = 1;
                    }
                    else
                    {
                        f=f/simplify(f,g);
                        if(f==Integer.parseInt(str))
                            flag = 1;
                    }
                }
                if(S.equals("-"))
                {
                    if(str.contains("/")) {//数据类型为分数
                        text = str.split("/");
                        temp = Integer.parseInt(text[0]);
                        temp2 = Integer.parseInt(text[1]);
                        f=f/simplify(f,g);
                        g=g/simplify(f,g);
                        if(temp == f&&temp2 == g)
                            flag = 1;
                    }
                    else
                    {
                        f=f/simplify(f,g);
                        if(f==Integer.parseInt(str))
                            flag = 1;
                    }
                }
                if(S.equals("*"))
                {
                    if(str.contains("/")) {//数据类型为分数
                        text = str.split("/");
                        temp = Integer.parseInt(text[0]);
                        temp2 = Integer.parseInt(text[1]);
                        f=f/simplify(f,g);
                        g=g/simplify(f,g);
                        if(temp == f&&temp2 == g)
                            flag = 1;
                    }
                    else
                    {
                        f=f/simplify(f,g);
                        if(f==Integer.parseInt(str))
                            flag = 1;
                    }
                }
                if(S.equals("/"))
                {
                    if(str.contains("/")) {//数据类型为分数
                        text = str.split("/");
                        temp = Integer.parseInt(text[0]);
                        temp2 = Integer.parseInt(text[1]);
                        f=f/simplify(f,g);
                        g=g/simplify(f,g);
                        if(temp == f&&temp2 == g)
                            flag = 1;
                    }
                    else
                    {
                        f=f/simplify(f,g);
                        if(f==Integer.parseInt(str))
                            flag = 1;
                    }
                }break;
        }
        return flag;
    }


    public static int createzrs()
    {
        int zrs;
        java.util.Random r = new java.util.Random();
        zrs=r.nextInt(9)+1;
        return zrs;
    }
    public static int[]  createfs()

    {
        boolean k =true;
        int fs[] = new int[2];
        java.util.Random r = new java.util.Random();
        fs[0]=r.nextInt(9)+1;
        fs[1]=r.nextInt(9)+1;
        while(k)
        {
            if(fs[0]!=fs[1]) {
                k=false;
            }
            else
            {
                fs[1]=r.nextInt(9)+1;
            }
        }
        fs[0]=fs[0]/simplify(fs[0],fs[1]);
        fs[1]=fs[1]/simplify(fs[0],fs[1]);
        return fs;
    }
    public static String createsymbol()
    {
        java.util.Random r = new java.util.Random();
        int temp;
        String base = "+-*/";
        StringBuffer sb = new StringBuffer();
        temp=r.nextInt(base.length());
        sb.append(base.charAt(temp));
        String ss=sb.toString();
        return ss;
    }
    public static int simplify(int a,int b)
    {
        int c;
        c=a%b;
        while( c!=0 )
        {
            a=b;
            b=c;
            c=a%b;
        }
        return b;
    }
}
