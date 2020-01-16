package com.hui.pojo.web.model.response;

import com.hui.pojo.base.util.CommonUtil;
import com.hui.pojo.dto.ProIncrementServiceDTO;
import com.hui.pojo.dto.ProTaskDTO;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class IncrementServiceVO implements Serializable {

    private static final long serialVersionUID = -6705661377768969601L;

    private Long incrementServiceId;

    /**
     * 任务编号
     */
    private String taskSn;

    /**
     * 是否精准投放:0否,1是
     */
    private Boolean whetherPreciseDelivery;

    /**
     * 精准投放金豆
     */
    private BigDecimal preciseDeliveryGoldPea;

    /**
     * 是否试用任务审核:0否,1是
     */
    private Boolean whetherTaskAudite;

    /**
     * 试用任务审核金豆
     */
    private BigDecimal taskAuditeGoldPea;

    /**
     * 是否提升店铺回访:0否,1是
     */
    private Boolean whetherStoreVisit;

    /**
     * 店铺回访金额
     */
    private BigDecimal storeVisitGoldPea;

    /**
     * 是否金豆奖励:0否,1是
     */
    private Boolean whetherGoldPeaAward;

    /**
     * 金豆奖励(金豆每人)
     */
    private BigDecimal awardGoldPea;

    /**
     * 设置奖励人数
     */
    private Integer goldPeaAwardPeople;

    /**
     * 是否广告位投放:0否,1是
     */
    private Boolean whetherAdPosition;

    /**
     * 广告位投放金豆
     */
    private BigDecimal adPositionGoldPea;

    /**
     * 是否禁止老用户中奖:0否,1是
     */
    private Boolean whetherForbidOldWin;

    /**
     * 禁止老用户中奖 0=30,1=60,2=90,3=150
     */
    private Integer forbidOldWin;

    /**
     * 禁止老用户中奖金豆
     */
    private BigDecimal forbidOldWinGoldPea;

    /**
     * 是否搜索关键词截图:0否,1是
     */
    private Boolean whetherSearchKeywordScreenshot;

    /**
     * 搜索关键词截图金豆
     */
    private BigDecimal searchKeywordScreenshotGoldPea;

    /**
     * 是否短信催付:0否,1是
     */
    private Boolean whetherSmsUrgePay;

    /**
     * 短信催付/每单金豆
     */
    private BigDecimal smsUrgePayGoldPea;

    /**
     * 是否浏览宝贝详情页中的问题:0否,1是
     */
    private Boolean whetherViewQuestion;

    /**
     * 浏览宝贝详情页中的问题金豆
     */
    private BigDecimal viewQuestionGoldPea;

    /**
     * 浏览宝贝详情页中的问题
     */
    private String viewQuestion;

    /**
     * 浏览宝贝详情页中的问题答案
     */
    private String viewAnswer;

    /**
     * 是否试客2小时内下单:0否,1是
     */
    private Boolean whetherFastOrder;

    /**
     * 是否细化中奖人群
     */
    private Boolean whetherRefinementWinners;

    /**
     * 是否设置性别 :0否,1是
     */
    private Boolean whetherSex;

    /**
     * 性别 0男 1女
     */
    private Integer sexSelect;

    /**
     * 设置下单人数
     */
    private Integer sexPeople;

    /**
     * 性别下单金豆/人
     */
    private BigDecimal sexGoldPea;

    /**
     * 是否设置年龄段 :0否,1是
     */
    private Boolean whetherAge;

    /**
     * 年龄段(多选) 0:18-26,1:26-37,2:37-51,3:51岁以上
     */
    private String ageSelect;

    /**
     * 设置年龄段下单人数
     */
    private Integer agePeople;

    /**
     * 年龄段下单金豆/人
     */
    private BigDecimal ageGoldPea;

    /**
     * 是否设置职业 :0否,1是
     */
    private Boolean whetherProfession;

    /**
     * 职业选择(多选):学生党  上班族  房地产  教职工  医疗单位  白领  自主运营 公务员  工人  宝妈  全职太太  其他
     */
    private String professionSelect;

    /**
     * 设置职业下单人数
     */
    private Integer professionPeople;

    /**
     * 职业下单金豆/人
     */
    private BigDecimal professionGoldPea;

    /**
     * 是否选择好评关键字
     */
    private Boolean whetherGoodKeywords;

    /**
     * 好评关键字总评价人数
     */
    private Integer goodKeywords;

    /**
     * 好评关键字金豆/单
     */
    private BigDecimal goodKeywordsGoldPea;

    /**
     * 是否选择普通图文好评(优质好评)
     */
    private Boolean whetherImageTextEvaluate;

    /**
     * 设置普通图文好评人数
     */
    private Integer imageTextPeople;

    /**
     * 优质好评-普通图文好评-金豆/人
     */
    private BigDecimal imageTextGoldPea;

    /**
     * 是否选择买家秀评价
     */
    private Boolean whetherBuyShowEvaluate;

    /**
     * 设置买家秀评价人数
     */
    private Integer buyShowPeople;

    /**
     * 买家秀评价-金豆/人
     */
    private BigDecimal buyShowGoldPea;

    /**
     * 是否选择五星好评
     */
    private Boolean whetherFivestarsEvaluate;

    /**
     * 五星好评比例
     */
    private Integer fivestarsEvaluate;

    /**
     * 设置五星评价人数
     */
    private Integer fivestarsEvaluatePeople;

    /**
     * 设置文字评价人数
     */
    private Integer wordsEvaluatePeople;

    /**
     * 试用担保金收取比例(10，就是10%)
     */
    private Integer guaranteeRate;

    /**
     * 运费金额/试用备用金
     */
    private String  mailMoney;

    /**
     * 商品价格
     */
    private String  productPrice;

    /**
     * 关键词评论
     */
    private List<KeywordsEvaluateListVO> proKeywordsEvaluates = new ArrayList<KeywordsEvaluateListVO>();


    private void copyFrom(ProIncrementServiceDTO proIncrementServiceDTO,ProTaskDTO proTaskProductDTO) {
        this.incrementServiceId = proIncrementServiceDTO.getId();
        this.taskSn = proIncrementServiceDTO.getTaskSn();
        this.whetherPreciseDelivery = proIncrementServiceDTO.getWhetherPreciseDelivery();
        this.preciseDeliveryGoldPea = proIncrementServiceDTO.getPreciseDeliveryGoldPea();
        this.whetherTaskAudite = proIncrementServiceDTO.getWhetherTaskAudite();
        this.taskAuditeGoldPea = proIncrementServiceDTO.getTaskAuditeGoldPea();
        this.whetherStoreVisit = proIncrementServiceDTO.getWhetherStoreVisit();
        this.storeVisitGoldPea = proIncrementServiceDTO.getStoreVisitGoldPea();
        this.whetherGoldPeaAward = proIncrementServiceDTO.getWhetherGoldPeaAward();
        this.awardGoldPea = proIncrementServiceDTO.getAwardGoldPea();
        this.goldPeaAwardPeople = proIncrementServiceDTO.getGoldPeaAwardPeople();
        this.whetherAdPosition = proIncrementServiceDTO.getWhetherAdPosition();
        this.adPositionGoldPea = proIncrementServiceDTO.getAdPositionGoldPea();
        this.whetherForbidOldWin = proIncrementServiceDTO.getWhetherForbidOldWin();
        this.forbidOldWin = proIncrementServiceDTO.getForbidOldWin();
        this.forbidOldWinGoldPea = proIncrementServiceDTO.getForbidOldWinGoldPea();
        this.whetherSearchKeywordScreenshot = proIncrementServiceDTO.getWhetherSearchKeywordScreenshot();
        this.searchKeywordScreenshotGoldPea = proIncrementServiceDTO.getSearchKeywordScreenshotGoldPea();
        this.whetherSmsUrgePay = proIncrementServiceDTO.getWhetherSmsUrgePay();
        this.smsUrgePayGoldPea = proIncrementServiceDTO.getSmsUrgePayGoldPea();
        this.whetherViewQuestion = proIncrementServiceDTO.getWhetherViewQuestion();
        this.viewQuestionGoldPea = proIncrementServiceDTO.getViewQuestionGoldPea();
        this.viewQuestion = proIncrementServiceDTO.getViewQuestion();
        this.viewAnswer = proIncrementServiceDTO.getViewAnswer();
        this.whetherFastOrder = proIncrementServiceDTO.getWhetherFastOrder();
        this.whetherRefinementWinners = proIncrementServiceDTO.getWhetherRefinementWinners();
        this.whetherSex = proIncrementServiceDTO.getWhetherSex();
        this.sexSelect = proIncrementServiceDTO.getSexSelect();
        this.sexPeople = proIncrementServiceDTO.getSexPeople();
        this.sexGoldPea = proIncrementServiceDTO.getSexGoldPea();
        this.whetherAge = proIncrementServiceDTO.getWhetherAge();
        this.ageSelect = proIncrementServiceDTO.getAgeSelect();
        this.agePeople = proIncrementServiceDTO.getAgePeople();
        this.ageGoldPea = proIncrementServiceDTO.getAgeGoldPea();
        this.whetherProfession = proIncrementServiceDTO.getWhetherProfession();
        this.professionSelect = proIncrementServiceDTO.getProfessionSelect();
        this.professionPeople = proIncrementServiceDTO.getProfessionPeople();
        this.professionGoldPea = proIncrementServiceDTO.getProfessionGoldPea();
        this.whetherGoodKeywords = proIncrementServiceDTO.getWhetherGoodKeywords();
        this.goodKeywords = proIncrementServiceDTO.getGoodKeywords();
        this.goodKeywordsGoldPea = proIncrementServiceDTO.getGoodKeywordsGoldPea();
        this.whetherImageTextEvaluate = proIncrementServiceDTO.getWhetherImageTextEvaluate();
        this.imageTextPeople = proIncrementServiceDTO.getImageTextPeople();
        this.imageTextGoldPea = proIncrementServiceDTO.getImageTextGoldPea();
        this.whetherBuyShowEvaluate = proIncrementServiceDTO.getWhetherBuyShowEvaluate();
        this.buyShowPeople = proIncrementServiceDTO.getBuyShowPeople();
        this.buyShowGoldPea = proIncrementServiceDTO.getBuyShowGoldPea();
        this.whetherFivestarsEvaluate = proIncrementServiceDTO.getWhetherFivestarsEvaluate();
        this.fivestarsEvaluate = proIncrementServiceDTO.getFivestarsEvaluate();
        this.fivestarsEvaluatePeople = proIncrementServiceDTO.getFivestarsEvaluatePeople();
        this.wordsEvaluatePeople = proIncrementServiceDTO.getWordsEvaluatePeople();
        this.guaranteeRate = proTaskProductDTO.getGuaranteeRate();
        this.mailMoney = CommonUtil.mathToDivid(proTaskProductDTO.getMailMoney(),100);
        this.productPrice = proTaskProductDTO.getfenToyuanPrice();
    }
    public static IncrementServiceVO bindData(ProIncrementServiceDTO proIncrementServiceDTO,ProTaskDTO proTaskProductDTO) {
        IncrementServiceVO model = new IncrementServiceVO();
        if (proIncrementServiceDTO!=null) {
            model.copyFrom(proIncrementServiceDTO,proTaskProductDTO);
        }
        return model;
    }

    private void copyFrom(ProTaskDTO proIncrementServiceDTO) {
        this.incrementServiceId = proIncrementServiceDTO.getId();
        this.taskSn = proIncrementServiceDTO.getTaskSn();
        this.whetherPreciseDelivery = proIncrementServiceDTO.getWhetherPreciseDelivery();
        this.preciseDeliveryGoldPea = proIncrementServiceDTO.getPreciseDeliveryGoldPea();
        this.whetherTaskAudite = proIncrementServiceDTO.getWhetherTaskAudite();
        this.taskAuditeGoldPea = proIncrementServiceDTO.getTaskAuditeGoldPea();
        this.whetherStoreVisit = proIncrementServiceDTO.getWhetherStoreVisit();
        this.storeVisitGoldPea = proIncrementServiceDTO.getStoreVisitGoldPea();
        this.whetherGoldPeaAward = proIncrementServiceDTO.getWhetherGoldPeaAward();
        this.awardGoldPea = proIncrementServiceDTO.getAwardGoldPea();
        this.goldPeaAwardPeople = proIncrementServiceDTO.getGoldPeaAwardPeople();
        this.whetherAdPosition = proIncrementServiceDTO.getWhetherAdPosition();
        this.adPositionGoldPea = proIncrementServiceDTO.getAdPositionGoldPea();
        this.whetherForbidOldWin = proIncrementServiceDTO.getWhetherForbidOldWin();
        this.forbidOldWin = proIncrementServiceDTO.getForbidOldWin();
        this.forbidOldWinGoldPea = proIncrementServiceDTO.getForbidOldWinGoldPea();
        this.whetherSearchKeywordScreenshot = proIncrementServiceDTO.getWhetherSearchKeywordScreenshot();
        this.searchKeywordScreenshotGoldPea = proIncrementServiceDTO.getSearchKeywordScreenshotGoldPea();
        this.whetherSmsUrgePay = proIncrementServiceDTO.getWhetherSmsUrgePay();
        this.smsUrgePayGoldPea = proIncrementServiceDTO.getSmsUrgePayGoldPea();
        this.whetherViewQuestion = proIncrementServiceDTO.getWhetherViewQuestion();
        this.viewQuestionGoldPea = proIncrementServiceDTO.getViewQuestionGoldPea();
        this.viewQuestion = proIncrementServiceDTO.getViewQuestion();
        this.viewAnswer = proIncrementServiceDTO.getViewAnswer();
        this.whetherFastOrder = proIncrementServiceDTO.getWhetherFastOrder();
        this.whetherRefinementWinners = proIncrementServiceDTO.getWhetherRefinementWinners();
        this.whetherSex = proIncrementServiceDTO.getWhetherSex();
        this.sexSelect = proIncrementServiceDTO.getSexSelect();
        this.sexPeople = proIncrementServiceDTO.getSexPeople();
        this.sexGoldPea = proIncrementServiceDTO.getSexGoldPea();
        this.whetherAge = proIncrementServiceDTO.getWhetherAge();
        this.ageSelect = proIncrementServiceDTO.getAgeSelect();
        this.agePeople = proIncrementServiceDTO.getAgePeople();
        this.ageGoldPea = proIncrementServiceDTO.getAgeGoldPea();
        this.whetherProfession = proIncrementServiceDTO.getWhetherProfession();
        this.professionSelect = proIncrementServiceDTO.getProfessionSelect();
        this.professionPeople = proIncrementServiceDTO.getProfessionPeople();
        this.professionGoldPea = proIncrementServiceDTO.getProfessionGoldPea();
        this.whetherGoodKeywords = proIncrementServiceDTO.getWhetherGoodKeywords();
        this.goodKeywords = proIncrementServiceDTO.getGoodKeywords();
        this.goodKeywordsGoldPea = proIncrementServiceDTO.getGoodKeywordsGoldPea();
        this.whetherImageTextEvaluate = proIncrementServiceDTO.getWhetherImageTextEvaluate();
        this.imageTextPeople = proIncrementServiceDTO.getImageTextPeople();
        this.imageTextGoldPea = proIncrementServiceDTO.getImageTextGoldPea();
        this.whetherBuyShowEvaluate = proIncrementServiceDTO.getWhetherBuyShowEvaluate();
        this.buyShowPeople = proIncrementServiceDTO.getBuyShowPeople();
        this.buyShowGoldPea = proIncrementServiceDTO.getBuyShowGoldPea();
        this.whetherFivestarsEvaluate = proIncrementServiceDTO.getWhetherFivestarsEvaluate();
        this.fivestarsEvaluate = proIncrementServiceDTO.getFivestarsEvaluate();
        this.fivestarsEvaluatePeople = proIncrementServiceDTO.getFivestarsEvaluatePeople();
        this.wordsEvaluatePeople = proIncrementServiceDTO.getWordsEvaluatePeople();
        this.guaranteeRate = proIncrementServiceDTO.getGuaranteeRate();
        this.mailMoney = CommonUtil.mathToDivid(proIncrementServiceDTO.getMailMoney(),100);
        this.productPrice = proIncrementServiceDTO.getfenToyuanPrice();
    }
    public static IncrementServiceVO bindData(ProTaskDTO proIncrementServiceDTO) {
        IncrementServiceVO model = new IncrementServiceVO();
        if (proIncrementServiceDTO!=null) {
            model.copyFrom(proIncrementServiceDTO);
        }
        return model;
    }
}