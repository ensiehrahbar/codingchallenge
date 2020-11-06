/* package de.sevensender.codingchallenge.serviceImpl;

 import com.rometools.rome.io.FeedException;
import de.sevensender.codingchallenge.model.CustomJson;
import de.sevensender.codingchallenge.util.RSSFeedsParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/*
@ExtendWith(SpringExtension.class)
class JsonServiceImplTest {

    @Mock
    RSSFeedsParser rssFeedsParser;
    @Mock
    XkcdReader xkcdReader;
    @InjectMocks
    JsonServiceImpl jsonService;


    @Test
    void ShouldAssertTrueForFeed() throws IOException, FeedException {
        List<CustomJson> feed = new ArrayList<>();
        feed.add(new CustomJson("titleFeed1","e",new Date(20201107),"ei"));
        feed.add(new CustomJson("titleFeed1","f",new Date(20201107),"fi"));
        feed.add(new CustomJson("titleFeed1","g",new Date(20201107),"gi"));
        feed.add(new CustomJson("titleFeed1","h",new Date(20201107),"hi"));
        feed.add(new CustomJson("titleFeed1","i",new Date(20201107),"ii"));
        Mockito.when(rssFeedsParser.parse(Mockito.anyString())).thenReturn(feed);
        List<CustomJson> returnResult=jsonService.getLast10RecordRssFeed();
        Assertions.assertTrue(returnResult.size()>0);
    }
    @Test
  /*  void ShouldAssertTrueForXkcd() throws IOException {
        List<CustomJson> cj = new ArrayList<>();
        cj.add(new CustomJson("title1","a", new Date(20201106),"a"));
        cj.add(new CustomJson("title2","b", new Date(20201106),"b"));
        cj.add(new CustomJson("title3","c", new Date(20201106),"c"));
        cj.add(new CustomJson("title4","d", new Date(20201106),"d"));
  //      Mockito.when(xkcdReader.lastXkcdNumber(Mockito.anyString())).thenReturn(5);
//        Mockito.when(xkcdReader.xkcdParser(Mockito.anyInt())).thenReturn(cj);
    //    List<CustomJson> returnResult = jsonService.getLast10RecordXkcd();
      //  Assertions.assertTrue(returnResult.size()>0);

    }
  //  @Test
  //  void ShouldAssertTrueForAll() throws IOException,FeedException{
    //    List<CustomJson> allData = new ArrayList<CustomJson>();
       // allData=jsonService.getLast10RecordXkcd();
        //allData=jsonService.getLast10RecordRssFeed();
      //  Assertions.assertTrue(allData.size()>0);
    //}
*/