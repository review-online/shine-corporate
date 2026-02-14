package com.shine.corporate.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ContentService {

    public Map<String, Object> getCompanyInfo() {
        Map<String, Object> company = new HashMap<>();
        company.put("name", "株式会社SHINE");
        company.put("englishName", "SHINE Corporation");
        company.put("representative", "小林 剛");
        company.put("representativeTitle", "代表取締役");
        company.put("established", "2018年4月1日");
        company.put("capital", "30,000,000円");
        company.put("employees", "42名（パート・アルバイト含む）");
        company.put("address", "〒192-0082 東京都八王子市東町11-2 千島ビル4階");
        company.put("phone", "042-649-3516");
        company.put("fax", "042-626-8801");
        company.put("email", "info@shine-corp.co.jp");
        company.put("philosophy", "お酒を通じて人々により豊かな時間と暮らしを与える");
        company.put("businessDescription", "バー・ナイトクラブの企画・運営／イベントプロデュース");
        return company;
    }

    public Map<String, String> getCeoMessage() {
        Map<String, String> message = new HashMap<>();
        message.put("title", "お酒を通じて、人生に輝きを");
        message.put("subtitle", "八王子から、ナイトエコノミーの新しいスタンダードを");

        String content = """
            株式会社SHINEのホームページをご覧いただき、誠にありがとうございます。代表取締役の小林剛と申します。
            
            私たちは「お酒を通じて人々により豊かな時間と暮らしを与える」という理念のもと、八王子の地でバーとナイトクラブを運営しております。
            この理念は、私自身が長年この業界に携わる中で、お酒が持つ特別な力を実感してきたことから生まれました。
            
            お酒は単なる飲み物ではありません。それは人と人をつなぎ、会話を弾ませ、日常の喧騒から離れた特別な時間を演出する、
            かけがえのない存在です。一杯のカクテルが、疲れた心を癒す。仲間との乾杯が、絆を深める。
            そんな瞬間に立ち会えることが、私たちの仕事の醍醐味であり、誇りでもあります。
            
            八王子という街は、古くからの歴史と新しい文化が共存する、魅力あふれる場所です。
            私たちは、この地域社会の一員として、単なる娯楽施設の運営にとどまらず、地域のナイトエコノミー活性化に貢献したいと考えています。
            
            また、私たちは「しっかりとした企業」として、コンプライアンス（法令遵守）を最優先事項として掲げています。
            お客様に安心して楽しんでいただける空間、スタッフが胸を張って働ける環境。これらを徹底することで、
            ナイトビジネスに対する従来のイメージを変革し、信頼される企業を目指してまいります。
            
            これからも、株式会社SHINEは「お酒を通じて人々により豊かな時間と暮らしを与える」という理念を胸に、
            八王子、そして多摩地域のナイトエコノミーの発展に貢献してまいります。
            
            皆様のご来店を、心よりお待ちしております。
            """;

        message.put("content", content);
        message.put("signature", "株式会社SHINE 代表取締役");
        message.put("name", "小林 剛");

        return message;
    }

    public List<Map<String, String>> getBusinessDetails() {
        List<Map<String, String>> businesses = new ArrayList<>();

        Map<String, String> bar = new HashMap<>();
        bar.put("title", "プレミアムバー運営");
        bar.put("icon", "🍸");
        bar.put("storeName", "BAR SHINE");
        bar.put("description", "厳選された国内外のウイスキー、ワイン、日本酒を取り揃えた大人のための上質な空間。経験豊富なバーテンダーが、お客様一人ひとりの好みに合わせて最適な一杯をご提案いたします。");
        bar.put("image", "bar-interior.png");
        businesses.add(bar);

        Map<String, String> club = new HashMap<>();
        club.put("title", "ナイトクラブ運営");
        club.put("icon", "🎵");
        club.put("storeName", "CLUB LUXE");
        club.put("description", "最新の音響・照明設備を備えた、多摩地域最大級のナイトクラブ。国内外の一流DJを招いたイベントから、カジュアルなパーティーまで、幅広いニーズに対応。");
        club.put("image", "club-interior.png");
        businesses.add(club);

        return businesses;
    }
}
