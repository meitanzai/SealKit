import com.liuzy88.seal.Config;
import com.liuzy88.seal.OfficialSeal;
import com.liuzy88.seal.PrivateSeal;
import com.liuzy88.seal.Seal;

public class Main {

    public static void main(String[] args) throws Exception {
        Config config = new Config();
        config.setImageSize(200);
        config.setBorderCircle(new Seal.Circle()
                .setLineSize(4)
                .setWidth(95)
                .setHeight(95));
        config.setMainFont(new Seal.Words()
                .setFontText("中国银联股份有限公司")
                .setFontSize(22)
                .setFontSpace(22.0)
                .setMarginSize(4));
        config.setCenterFont(new Seal.Words()
                .setFontText("★")
                .setFontSize(60));
        config.setTitleFont(new Seal.Words()
                .setFontText("电子签章")
                .setFontSize(16)
                .setFontSpace(8.0)
                .setMarginSize(54));
        OfficialSeal.buildAndStoreSeal(config, "out/公章.png");

        Config round = new Config();
        round.setImageSize(300);
        round.setBorderCircle(new Seal.Circle()
                .setLineSize(5)
                .setWidth(140)
                .setHeight(140));
        round.setMainFont(new Seal.Words()
                .setFontText("中国银联股份有限公司")
                .setFontSize(35)
                .setFontSpace(35.0)
                .setMarginSize(10));
        round.setCenterFont(new Seal.Words()
                .setFontText("★")
                .setFontSize(100));
        round.setTitleFont(new Seal.Words()
                .setFontText("电子签章")
                .setFontSize(22)
                .setFontSpace(10.0)
                .setMarginSize(68));
        OfficialSeal.buildAndStoreSeal(round, "out/公章1.png");

        Config ellipse = new Config();
        ellipse.setImageSize(300);
        ellipse.setBorderCircle(new Seal.Circle()
                .setLineSize(3)
                .setWidth(140)
                .setHeight(100));
        ellipse.setBorderInnerCircle(new Seal.Circle()
                .setLineSize(1)
                .setWidth(135)
                .setHeight(95));
        ellipse.setMainFont(new Seal.Words()
                .setFontText("中国银联股份有限公司")
                .setFontSize(25)
                .setFontSpace(12.0)
                .setMarginSize(10));
        ellipse.setCenterFont(new Seal.Words()
                .setFontText("7352361562587430")
                .setFontSize(20));
        ellipse.setTitleFont(new Seal.Words()
                .setFontText("财务专用章")
                .setFontSize(22)
                .setFontSpace(10.0)
                .setMarginSize(64));
        OfficialSeal.buildAndStoreSeal(ellipse, "out//公章2.png");

        PrivateSeal.draw(
                300,
                16,
                new Seal.Words().setFontText("刘仲阳").setFontSize(120),
                "印",
                "out//私章1.png");

        PrivateSeal.draw(
                300,
                16,
                new Seal.Words().setFontText("诸葛孔明").setFontSize(120),
                "印",
                "out//私章2.png");
    }
}
