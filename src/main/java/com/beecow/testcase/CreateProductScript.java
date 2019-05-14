package com.beecow.testcase;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beecow.actions.CreateProductPage;
import com.beecow.actions.HomePage;
import com.beecow.actions.LoginPage;

import CommonPage.Commontestcase;

public class CreateProductScript extends Commontestcase {
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	CreateProductPage createProductPage;
	String imgUploadRequiredMsg, nameProductRequiredMsg, categoryRequiredMsg, descriptionRequiredMsg,
			quantityRequiredMsg, priceRequiredMsg, weightRequiredMsg, requiredMsg, locatorDataImage, nameProdMsg,
			postProductSuccessfulMsg, productName, description, sku, quantity, quantityEdit, priceInput,
			priceProductNoDiscount, priceDisplayProduct, priceNewDiscount, priceViewEdit, discount, weight,
			weightSmallerRange, weightBiggerRange, weightMustRangeMsg, weightMin, width, widthMustRangeMsg,
			widthSmallerRange, widthBiggerRange, widthMin, length, lenghtOne, lengthBiggerRange, lengthSmallerRange,
			lengthMustRangeMsg, height, heightOne, heightBiggerRange, heightSmallerRange, heightMustRangeMsg,
			outOfStock, updateProductSuccessfulMsg;

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void BeforeClass(String browser, String version, String url) throws Exception {
		driver = openMultiBrowser(browser, version, url);
		homePage = PageFactory.initElements(driver, HomePage.class);
		loginPage = homePage.clickdangnhap();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.inputEmailorSdt("genymotionios@gmail.com");
		loginPage.iputMatkhau("1234@abcd");
		homePage = loginPage.clickbuttonDangnhap();
		Thread.sleep(3000);
		createProductPage = homePage.clickSellerPage();
		Thread.sleep(3000);
		// upload picture in foder project
		String userPath = System.getProperty("user.dir");
		String pathImage = userPath.concat("\\image\\2019259.jpg");
		locatorDataImage = pathImage;
		// msg
		imgUploadRequiredMsg = "Hãy chọn hình ảnh cho sản phẩm";
		nameProductRequiredMsg = "Hãy điền tên sản phẩm";
		categoryRequiredMsg = "Hãy chọn danh mục.";
		descriptionRequiredMsg = "Hãy mô tả sản phẩm.";
		quantityRequiredMsg = "Nhập số lượng.";
		priceRequiredMsg = "Hãy điền giá.";
		weightRequiredMsg = "Hãy điền cân nặng sản phẩm.";
		requiredMsg = "Bắt buộc";
		postProductSuccessfulMsg = "Bạn đã đăng thành công sản phẩm này";
		updateProductSuccessfulMsg = "Bạn đã cập nhật thành công sản phẩm này";
		outOfStock = "Hết hàng";
		heightMustRangeMsg = "Từ 1cm tới 50cm";
		lengthMustRangeMsg = "Từ 1cm tới 30cm";
		weightMustRangeMsg = "Cân nặng từ 50g đến 10000g.";
		widthMustRangeMsg = "Từ 1cm tới 50cm";
		// description
		description = "Description product";
		// sku
		sku = "SKUShirt";
		// Quantity
		quantity = "10";
		quantityEdit = "0";
		// Price:
		priceInput = "8";
		priceViewEdit = "8,000";
		priceDisplayProduct = "đ 7,200";
		priceProductNoDiscount = "đ 8,000";
		priceNewDiscount = "7,200";
		// Discount:
		discount = "10";
		// Weight
		weightMin = "50";
		weight = "10000";
		weightSmallerRange = "49";
		weightBiggerRange = "10001";
		// Width: "50"
		width = "50";
		widthMin = "1";
		widthSmallerRange = "0";
		widthBiggerRange = "51";
		// Length
		length = "30";
		lenghtOne = "1";
		lengthBiggerRange = "31";
		lengthSmallerRange = "0";
		// Height
		height = "50";
		heightOne = "1";
		heightSmallerRange = "0";
		heightBiggerRange = "51";
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://www.beecow.com/page/upload-product");
		productName = "XuanHoang" + randomName();
	}

//	TC8_ "1. At Home Page, click label ""Kênh bán hàng""
//	2. Click label: ""Đăng sản phẩm mới""".Verify current url is \"https://www.beecow.com/page/upload-product\"

	@Test
	public void TC_08() {
		String currrentUrl = driver.getCurrentUrl();
		assertEquals(currrentUrl, "https://www.beecow.com/page/upload-product");
	}

	@Test
	public void TC_09() throws Exception {
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(imgUploadRequiredMsg), "Hãy chọn hình ảnh cho sản phẩm");
		verifyEqual(createProductPage.getDynamicText(nameProductRequiredMsg), "Hãy điền tên sản phẩm");
		verifyEqual(createProductPage.getDynamicText(categoryRequiredMsg), "Hãy chọn danh mục.");
		verifyEqual(createProductPage.getDynamicText(descriptionRequiredMsg), "Hãy mô tả sản phẩm.");
		verifyEqual(createProductPage.getDynamicText(quantityRequiredMsg), "Nhập số lượng.");
		verifyEqual(createProductPage.getDynamicText(priceRequiredMsg), "Hãy điền giá.");
		verifyEqual(createProductPage.getDynamicText(weightRequiredMsg), "Hãy điền cân nặng sản phẩm.");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
	}

////    TC10 : Upload image
	@Test
	public void TC_10() throws Exception {
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(nameProductRequiredMsg), "Hãy điền tên sản phẩm");
		verifyEqual(createProductPage.getDynamicText(categoryRequiredMsg), "Hãy chọn danh mục.");
		verifyEqual(createProductPage.getDynamicText(descriptionRequiredMsg), "Hãy mô tả sản phẩm.");
		verifyEqual(createProductPage.getDynamicText(quantityRequiredMsg), "Nhập số lượng.");
		verifyEqual(createProductPage.getDynamicText(priceRequiredMsg), "Hãy điền giá.");
		verifyEqual(createProductPage.getDynamicText(weightRequiredMsg), "Hãy điền cân nặng sản phẩm.");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
	}

//TC 11 : 1. Upload image 2. Input random product name
	@Test
	public void TC_11() throws Exception {
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(categoryRequiredMsg), "Hãy chọn danh mục.");
		verifyEqual(createProductPage.getDynamicText(descriptionRequiredMsg), "Hãy mô tả sản phẩm.");
		verifyEqual(createProductPage.getDynamicText(quantityRequiredMsg), "Nhập số lượng.");
		verifyEqual(createProductPage.getDynamicText(priceRequiredMsg), "Hãy điền giá.");
		verifyEqual(createProductPage.getDynamicText(weightRequiredMsg), "Hãy điền cân nặng sản phẩm.");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
	}

//	TC12 : 1. Upload image 2. Input random product name 3. Select random combobox "Chọn danh mục"(1)
	@Test
	public void TC_12() throws Exception {
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(categoryRequiredMsg), "Hãy chọn danh mục.");
		verifyEqual(createProductPage.getDynamicText(descriptionRequiredMsg), "Hãy mô tả sản phẩm.");
		verifyEqual(createProductPage.getDynamicText(quantityRequiredMsg), "Nhập số lượng.");
		verifyEqual(createProductPage.getDynamicText(priceRequiredMsg), "Hãy điền giá.");
		verifyEqual(createProductPage.getDynamicText(weightRequiredMsg), "Hãy điền cân nặng sản phẩm.");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
	}

//	TC13 : 1. Upload image2. Input random product name3. Select random combobox "Chọn danh mục"(1)3. Select random combobox "Chọn danh mục"(2)
	@Test
	public void TC_13() throws Exception {
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(descriptionRequiredMsg), "Hãy mô tả sản phẩm.");
		verifyEqual(createProductPage.getDynamicText(quantityRequiredMsg), "Nhập số lượng.");
		verifyEqual(createProductPage.getDynamicText(priceRequiredMsg), "Hãy điền giá.");
		verifyEqual(createProductPage.getDynamicText(weightRequiredMsg), "Hãy điền cân nặng sản phẩm.");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
	}

//TC 14 1. Upload image2. Input random product name3. Select random combobox "Chọn danh mục"(1)4. Select random combobox "Chọn danh mục"(2)5. Input description: "Description product"
	@Test
	public void TC_14() throws Exception {
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		createProductPage.inputDescription(description);
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(quantityRequiredMsg), "Nhập số lượng.");
		verifyEqual(createProductPage.getDynamicText(priceRequiredMsg), "Hãy điền giá.");
		verifyEqual(createProductPage.getDynamicText(weightRequiredMsg), "Hãy điền cân nặng sản phẩm.");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
	}

	// TC 15 1. Upload image2. Input random product name3. Select random combobox
	// "Chọn danh mục"(1)4. Select random combobox "Chọn danh mục"(2)5. Input
	// description: "Description product"
//	Input Quantity: "10"
	@Test
	public void TC_15() throws Exception {
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		createProductPage.inputDescription(description);
		createProductPage.inputQuantity(quantity);
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(priceRequiredMsg), "Hãy điền giá.");
		verifyEqual(createProductPage.getDynamicText(weightRequiredMsg), "Hãy điền cân nặng sản phẩm.");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
	}

	// TC16 Input Quantity: "10"7. Input Price: "8"
	@Test
	public void TC_16() throws Exception {
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		createProductPage.inputDescription(description);
		createProductPage.inputQuantity(quantity);
		createProductPage.inputPrice(priceInput);
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(weightRequiredMsg), "Hãy điền cân nặng sản phẩm.");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
	}

//	// TC17 Input Weight: "49"1. Weight: "Cân nặng từ 50g đến 10000g."
	@Test
	public void TC_17() throws Exception {
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		createProductPage.inputDescription(description);
		createProductPage.inputQuantity(quantity);
		createProductPage.inputPrice(priceInput);
		createProductPage.inputWeight(weightSmallerRange);
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(weightMustRangeMsg), "Cân nặng từ 50g đến 10000g.");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
	}
//Tc18 8. Input Weight: "10001" weightBiggerRange

	@Test
	public void TC_18() throws Exception {
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		createProductPage.inputDescription(description);
		createProductPage.inputQuantity(quantity);
		createProductPage.inputPrice(priceInput);
		createProductPage.inputWeight(weightBiggerRange);
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(weightMustRangeMsg), "Cân nặng từ 50g đến 10000g.");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
	}

	@Test
	public void TC_19() throws Exception {
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		createProductPage.inputDescription(description);
		createProductPage.inputQuantity(quantity);
		createProductPage.inputPrice(priceInput);
		createProductPage.inputWeight(weightMin);
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
	}

	@Test
	public void TC_20() throws Exception {
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		createProductPage.inputDescription(description);
		createProductPage.inputQuantity(quantity);
		createProductPage.inputPrice(priceInput);
		createProductPage.inputWeight(weight);
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
	}

	@Test
	public void TC_21() throws Exception {
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		createProductPage.inputDescription(description);
		createProductPage.inputQuantity(quantity);
		createProductPage.inputPrice(priceInput);
		createProductPage.inputWeight(weight);
		createProductPage.inputWidth(widthSmallerRange);
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(widthMustRangeMsg), "Từ 1cm tới 50cm");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
	}

	@Test
	public void TC_22() throws Exception {
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		createProductPage.inputDescription(description);
		createProductPage.inputQuantity(quantity);
		createProductPage.inputPrice(priceInput);
		createProductPage.inputWeight(weight);
		createProductPage.inputWidth(widthBiggerRange);
		createProductPage.clickPost();
		Thread.sleep(1000);
		verifyEqual(createProductPage.getDynamicText(widthMustRangeMsg), "Từ 1cm tới 50cm");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
	}

	@Test
	public void TC_23() throws Exception {
		productName = "XuanHoang" + randomName();
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		Thread.sleep(1000);
		createProductPage.inputDescription(description);
		createProductPage.inputQuantity(quantity);
		createProductPage.inputPrice(priceInput);
		createProductPage.inputWeight(weight);
		createProductPage.inputWidth(widthMin);
		createProductPage.clickPost();
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
	}

	@Test
	public void TC_24() throws Exception {
		productName = "XuanHoang" + randomName();
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		Thread.sleep(1000);
		createProductPage.inputDescription(description);
		createProductPage.inputQuantity(quantity);
		createProductPage.inputPrice(priceInput);
		createProductPage.inputWeight(weight);
		createProductPage.inputWidth(width);
		createProductPage.clickPost();
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
	}

	@Test
	public void TC_25() throws Exception {
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		Thread.sleep(1000);
		createProductPage.inputDescription(description);
		createProductPage.inputQuantity(quantity);
		createProductPage.inputPrice(priceInput);
		createProductPage.inputWeight(weight);
		createProductPage.inputWidth(width);
		createProductPage.inputLength(lengthSmallerRange);
		createProductPage.clickPost();
		verifyEqual(createProductPage.getDynamicText(lengthMustRangeMsg), "Từ 1cm tới 30cm");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
	}

	@Test
	public void TC_26() throws Exception {
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		Thread.sleep(1000);
		createProductPage.inputDescription(description);
		createProductPage.inputQuantity(quantity);
		createProductPage.inputPrice(priceInput);
		createProductPage.inputWeight(weight);
		createProductPage.inputWidth(width);
		createProductPage.inputLength(lengthBiggerRange);
		createProductPage.clickPost();
		verifyEqual(createProductPage.getDynamicText(lengthMustRangeMsg), "Từ 1cm tới 30cm");
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
	}

	@Test
	public void TC_27() throws Exception {
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		Thread.sleep(1000);
		createProductPage.inputDescription(description);
		createProductPage.inputQuantity(quantity);
		createProductPage.inputPrice(priceInput);
		createProductPage.inputWeight(weight);
		createProductPage.inputWidth(width);
		createProductPage.inputLength(lenghtOne);
		createProductPage.clickPost();
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");
	}

	@Test
	public void TC_28() throws Exception {
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		Thread.sleep(1000);
		createProductPage.inputDescription(description);
		createProductPage.inputQuantity(quantity);
		createProductPage.inputPrice(priceInput);
		createProductPage.inputWeight(weight);
		createProductPage.inputWidth(width);
		createProductPage.inputLength(length);
		createProductPage.clickPost();
		verifyEqual(createProductPage.getDynamicText(requiredMsg), "Bắt buộc");

	}

	@Test
	public void TC_29() throws Exception {
		productName = "XuanHoang" + randomName();
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		Thread.sleep(1000);
		createProductPage.inputDescription(description);
		createProductPage.inputQuantity(quantity);
		createProductPage.inputPrice(priceInput);
		createProductPage.inputWeight(weight);
		createProductPage.inputWidth(width);
		createProductPage.inputLength(length);
		createProductPage.inputHeight(heightSmallerRange);
		createProductPage.clickPost();
		verifyEqual(createProductPage.getDynamicText(heightMustRangeMsg), "Từ 1cm tới 50cm");

	}

	@Test
	public void TC_30() throws Exception {
		productName = "XuanHoang" + randomName();
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		Thread.sleep(1000);
		createProductPage.inputDescription(description);
		createProductPage.inputQuantity(quantity);
		createProductPage.inputPrice(priceInput);
		createProductPage.inputWeight(weight);
		createProductPage.inputWidth(width);
		createProductPage.inputLength(length);
		createProductPage.inputHeight(heightBiggerRange);
		createProductPage.clickPost();
		verifyEqual(createProductPage.getDynamicText(heightMustRangeMsg), "Từ 1cm tới 50cm");

	}

	// TC31 . input height =1
	@Test
	public void TC_31() throws Exception {
		productName = "XuanHoang" + randomName();
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		Thread.sleep(1000);
		createProductPage.inputDescription(description);
		createProductPage.inputQuantity(quantity);
		createProductPage.inputPrice(priceInput);
		createProductPage.inputWeight(weight);
		createProductPage.inputWidth(width);
		createProductPage.inputLength(length);
		createProductPage.inputHeight(heightOne);
		createProductPage.clickPost();
		verifyEqual(createProductPage.getDynamicText(postProductSuccessfulMsg), "Bạn đã đăng thành công sản phẩm này");
		createProductPage.clickViewList();
		verifyEqual(createProductPage.getTextDisplayNameProduct(), productName);
		verifyEqual(createProductPage.getTextDisplayPrice(), priceProductNoDiscount);
		createProductPage.clickEditProduct(productName);
		createProductPage.deleteProduct();
		Thread.sleep(1000);

	}

//TC32 
	// 1. Upload image 2. Input random product name 3. Select random combobox "Chọn
	// danh mục"(1)
//	4. Select random combobox "Chọn danh mục"(2) 5. Input description: "Description product"
//	6. Input Quantity: "10" 7. Input Price: "8"  8. Input Weight: "10000"	9. Input Width: "50"	10. Input Length: "30"
//	11: Input Height: "50" 12. Click button: "Đăng"1. Verify message is displayed "Bạn đã đăng thành công sản phẩm này"
//	2. Click button: "Xem danh mục sản phẩm"3. Verify product name and price is displayed at shop page
	@Test
	public void TC_32() throws Exception {
		productName = "XuanHoang" + randomName();
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		Thread.sleep(1000);
		createProductPage.inputDescription(description);
		createProductPage.inputQuantity(quantity);
		createProductPage.inputPrice(priceInput);
		createProductPage.inputWeight(weight);
		createProductPage.inputWidth(width);
		createProductPage.inputLength(length);
		createProductPage.inputHeight(height);
		createProductPage.clickPost();
		verifyEqual(createProductPage.getDynamicText(postProductSuccessfulMsg), "Bạn đã đăng thành công sản phẩm này");
		createProductPage.clickViewList();
		verifyEqual(createProductPage.getTextDisplayNameProduct(), productName);
		verifyEqual(createProductPage.getTextDisplayPrice(), priceProductNoDiscount);
		createProductPage.clickEditProduct(productName);
		createProductPage.deleteProduct();
		Thread.sleep(1000);
	}

//	TC33 B1. Upload image
//	B2. Input random product name
//	B3. Select random combobox "Chọn danh mục"(1)
//	B4. Select random combobox "Chọn danh mục"(2)
//	B5. Input description: "Description product"
//	B6. Input SKU: "SKUShirt"
//	B7. Input Quantity: "10"
//	B8. Input Price: "8"
//	B9. Input Discount: "10"
//	B10. Input Weight: "10000"
//	B11. Input Width: "50"
//	B12. Input Length: "30"
//	B13: Input Height: "50" 
//	B14. Click button: "Đăng"
	// Verify message is displayed "Bạn đã đăng thành công sản phẩm này"
	// 2. Click button: "Xem danh mục sản phẩm"
//		3. Verify product name and price is displayed at shop page
//		4. Click button chỉnh sửa
//		5. Verify all fields like user have inputed

	@Test
	public void TC_33() throws Exception {
		productName = "XuanHoang" + randomName();
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		Thread.sleep(1000);
		createProductPage.inputDescription(description);
		createProductPage.inputSKU(sku);
		createProductPage.inputQuantity(quantity);
		createProductPage.inputPrice(priceInput);
		createProductPage.inputDiscount(discount);
		createProductPage.inputWeight(weight);
		createProductPage.inputWidth(width);
		createProductPage.inputLength(length);
		createProductPage.inputHeight(height);
		createProductPage.clickPost();
		verifyEqual(createProductPage.getDynamicText(postProductSuccessfulMsg), "Bạn đã đăng thành công sản phẩm này");
		createProductPage.clickViewList();
		// Verify product name and price is displayed at shop page
		verifyEqual(createProductPage.getTextDisplayNameProduct(), productName);
		verifyEqual(createProductPage.getTextDisplayPrice(), priceDisplayProduct);
		createProductPage.clickEditProduct(productName);
		verifyEqual(createProductPage.getTextJS("return $('#name').val()"), productName);
		verifyEqual(createProductPage.getTextEditDescription(), description);
		verifyEqual(createProductPage.getTextJS("return $('#org-sku').val()"), sku);
		verifyEqual(createProductPage.getTextJS("return $('input[formcontrolname=\"totalItem\"]').val()"), quantity);
		verifyEqual(createProductPage.getTextJS("return $('input[formcontrolname=\"orgPrice\"]').val()"),
				priceViewEdit);
		verifyEqual(createProductPage.getTextJS("return $('input[formcontrolname=\"totalItem\"]').val()"), discount);
		verifyEqual(createProductPage.getTextJS("return $('input[formcontrolname=\"newPrice\"]').val()"),
				priceNewDiscount);
		verifyEqual(createProductPage.getTextJS("return $('input[formcontrolname=\"weight\"]').val()"), weight);
		verifyEqual(createProductPage.getTextJS("return $('input[formcontrolname=\"width\"]').val()"), width);
		verifyEqual(createProductPage.getTextJS("return $('input[formcontrolname=\"length\"]').val()"), length);
		verifyEqual(createProductPage.getTextJS("return $('input[formcontrolname=\"height\"]').val()"), height);
		createProductPage.deleteProduct();
		Thread.sleep(1000);
	}

	@Test
	public void TC_34() throws Exception {
		productName = "XuanHoang" + randomName();
		createProductPage.uploadIMG(locatorDataImage);
		createProductPage.inputNameProduct(productName);
		createProductPage.clickCate1();
		createProductPage.clickRandomValueCate1();
		createProductPage.clickCate2();
		createProductPage.clickRandomValueCate2();
		createProductPage.clickRandomCat3();
		Thread.sleep(1000);
		createProductPage.inputDescription(description);
		createProductPage.inputSKU(sku);
		createProductPage.inputQuantity(quantity);
		createProductPage.inputPrice(priceInput);
		createProductPage.inputDiscount(discount);
		createProductPage.inputWeight(weight);
		createProductPage.inputWidth(width);
		createProductPage.inputLength(length);
		createProductPage.inputHeight(height);
		createProductPage.clickPost();
		createProductPage.clickViewList();
		createProductPage.clickEditProduct(productName);
		createProductPage.clickEditQuantity();
		createProductPage.inputEditQuantity(quantityEdit);
		createProductPage.clickConfirmQuantity();
		createProductPage.clickUpdate();
		verifyEqual(createProductPage.getDynamicText(updateProductSuccessfulMsg),
				"Bạn đã cập nhật thành công sản phẩm này");
		createProductPage.clickSeeProductDetail();
		Thread.sleep(2000);
		verifyEqual(createProductPage.getTextDisplayNameProductEdit(), productName);
		verifyEqual(createProductPage.getTextDisplayPrice(), priceDisplayProduct);
		verifyEqual(createProductPage.getDynamicText(outOfStock), "Hết hàng");
		createProductPage.clickEditProductSuccessful();
		createProductPage.deleteProduct();
		Thread.sleep(1000);

	}

	@AfterClass
	public void AfterClass() {
		 closeBrowser();
	}

}
