package m3105.gildedRose;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class InnTest {

	@Test
	public void should_getItems() {
		Inn inn = new Inn();
		assertThat(inn.getItems()).extracting("name").contains("+5 Dexterity Vest", "Aged Brie", "Elixir of the Mongoose",
													"Elixir of the Mongoose", "Sulfuras, Hand of Ragnaros", "Backstage passes to a TAFKAL80ETC concert",
													"Conjured Mana Cake");
		assertThat(inn.getItems()).extracting("quality").contains(20, 0, 7 80, 20, 6);
		
		assertThat(inn.getItems()).extracting("sellin")
	}
}