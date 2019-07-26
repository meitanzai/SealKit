import com.liuzy88.seal.Config;
import com.liuzy88.seal.OfficialSeal;
import com.liuzy88.seal.PrivateSeal;
import com.liuzy88.seal.Seal;

public class Main {

    public static void main(String[] args) throws Exception {
        Config round = new Config();
        round.setImageSize(300);
        round.setBorderCircle(Seal.circle()
                .setLineSize(5)
                .setWidth(140)
                .setHeight(140));
        round.setMainFont(Seal.words()
                .setFontText("中国银联股份有限公司")
                .setFontSize(35)
                .setFontSpace(35.0)
                .setMarginSize(10));
        round.setCenterFont(Seal.words()
                .setFontText("★")
                .setFontSize(100));
        round.setTitleFont(Seal.words()
                .setFontText("电子签章")
                .setFontSize(22)
                .setFontSpace(10.0)
                .setMarginSize(68));
        OfficialSeal.buildAndStoreSeal(round, "D:/公章1.png");

        Config ellipse = new Config();
        ellipse.setImageSize(300);
        ellipse.setBorderCircle(Seal.circle()
                .setLineSize(3)
                .setWidth(140)
                .setHeight(100));
        ellipse.setBorderInnerCircle(Seal.circle()
                .setLineSize(1)
                .setWidth(135)
                .setHeight(95));
        ellipse.setMainFont(Seal.words()
                .setFontText("中国银联股份有限公司")
                .setFontSize(25)
                .setFontSpace(12.0)
                .setMarginSize(10));
        ellipse.setCenterFont(Seal.words()
                .setFontText("7352361562587430")
                .setFontSize(20));
        ellipse.setTitleFont(Seal.words()
                .setFontText("财务专用章")
                .setFontSize(22)
                .setFontSpace(10.0)
                .setMarginSize(64));
        OfficialSeal.buildAndStoreSeal(ellipse, "D:/公章2.png");

        PrivateSeal.draw(
                300,
                16,
                Seal.words().setFontText("刘仲阳").setFontSize(120),
                "印",
                "D:/私章1.png");

        PrivateSeal.draw(
                300,
                16,
                Seal.words().setFontText("诸葛孔明").setFontSize(120),
                "印",
                "D:/私章2.png");
    }
}
