# EpubParser

EpubParser是一个用于解析ePUB文件的Java库.

EpubParser允许您逐页阅读ePUB内容。它的目的是减少内存消耗。它对于大型的ePUB文件很有用.

# Usage
使用相当简单。只需实例化读取器对象，输入ePUB文件路径，设置可选值，并开始通过<i>readSection</i>方法解析文件.

Example usage:

	Reader reader = new Reader();
	reader.setMaxContentPerSection(1000); // Max string length for the current page.
	reader.setIsIncludingTextContent(true); // Optional, to return the tags-excluded version.
	reader.setFullContent(epubFilePath); // Must call before readSection.

	BookSection bookSection = reader.readSection(pageIndex);
	String sectionContent = bookSection.getSectionContent(); // Returns content as html.
	String sectionTextContent = bookSection.getSectionTextContent(); // Excludes html tags.

若要保存页面和解析进度，请执行以下操作:

	reader.saveProgress();
	
然后再检查和装载:
	
	if (reader.isSavedProgressFound()) { // Available after calling setFullContent method.
		int lastSavedPage = reader.loadProgress();
	}

Check out <a href="https://github.com/mertakdut/EpubParser-Sample-Android-Application">EpubParser-Sample-Android-Application</a> for more info.
<a href="https://play.google.com/store/apps/details?id=com.github.epubparsersampleandroidapplication"> Google Play Link</a>

Check out my latest app written by using this library. <a href="https://play.google.com/store/apps/details?id=com.codefan.effectbookreader">Effective Reader</a>

# Setup

Gradle在项目构建中添加依赖项。

	compile 'com.github.mertakdut:EpubParser:1.0.95'

或者 maven构建它

	<dependency>
    		<groupId>com.github.mertakdut</groupId>
    		<artifactId>EpubParser</artifactId>
    		<version>1.0.95</version>
	</dependency>

