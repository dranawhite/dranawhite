/**
 * 该包使用Apache POI对MS EXCEL进行处理
 * <pre>
 * 1) 什么是Apache POI？
 *      Apache POI是一种流行的API，它允许程序员使用Java程序创建，修改和显示MS Office文件。这由Apache软件基金会开发使用Java分布式设计或修改Microsoft
 * Office文件的开源库。它包含类和方法对用户输入数据或文件到MS Office文档进行解码。
 * 2) Apache POI组件
 *      Apache POI包含类和方法，来将MS Office所有OLE 2文档复合。此API组件的列表如下。
 *  POIFS (较差混淆技术实现文件系统) : 此组件是所有其他POI元件的基本因素。它被用来明确地读取不同的文件。
 *  HSSF (可怕的电子表格格式) : 它被用来读取和写入MS-Excel文件的xls格式。
 *  XSSF (XML格式) : 它是用于MS-Excel中XLSX文件格式。
 *  HPSF (可怕的属性设置格式) : 它用来提取MS-Office文件属性设置。
 *  HWPF (可怕的字处理器格式) : 它是用来读取和写入MS-Word的文档扩展名的文件。
 *  XWPF (XML字处理器格式) : 它是用来读取和写入MS-Word的docx扩展名的文件。
 *  HSLF (可怕的幻灯片版式格式) : 它是用于读取，创建和编辑PowerPoint演示文稿。
 *  HDGF (可怕的图表格式) : 它包含类和方法为MS-Visio的二进制文件。
 *  HPBF (可怕的出版商格式) : 它被用来读取和写入MS-Publisher文件。
 * 3) Apache POI下载
 *  下载路径 <a href="http://poi.apache.org/download.html">Apache POI最新版本</a>
 * 4）添加jar包
 *   poi-3.9/poi.jar
 *   poi-3.9/poi-ooxml.jar
 *   poi-3.9/poi-ooxml-schemas.jar
 *   poi-3.9/ooxml-lib/dom4j.jar
 *   poi-3.9/ooxml-lib/xmlbeans.jar
 *
 *  详情参照 <a href="http://www.yiibai.com/apache_poi">Apache POI APIs</a>
 * </pre>
 *
 * @author dranawhite 2017/10/26
 * @version 1.0
 */
package com.dranawhite.office.excel;