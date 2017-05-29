package g24.Maven_G24;

import org.junit.Test;

public class TestCountNewsOnGolovnePage extends TestBase
{

	@Test
	public void countNewsOnGolovnePage()
	{
		PageUkrNetGolovne pageUkrNetGolovne = new PageUkrNetGolovne(m_driver, m_wait);

		pageUkrNetGolovne.openPage();

		System.out.println(pageUkrNetGolovne.elementForNewsList.size());

	}

}
