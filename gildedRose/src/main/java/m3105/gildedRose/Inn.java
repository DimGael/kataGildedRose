package m3105.gildedRose;

import java.util.ArrayList;
import java.util.List;

public class Inn {
	private List<Item> items;

	public Inn() {
		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));
	}

	public List<Item> getItems() {
		return items;
	}

	public void updateQuality() {
		for (int numItem = 0; numItem < items.size(); numItem++) {
			this.updateItemQuality(numItem);
		}

	}

	private void updateItemQuality(int numItem) {
		// Si l'item n'est pas "Aged Brie" et n'est pas "Backstage ..."
		if (items.get(numItem).getName().equals("Aged Brie") || items.get(numItem).getName().equals("Backstage passes to a TAFKAL80ETC concert")) // Sinon si l'item est "Aged Brie" ou "Backstage ..."
		{
			// Si la qualité de l'item est inférieur à 50
			if (items.get(numItem).getQuality() < 50) {
				items.get(numItem).setQuality(items.get(numItem).getQuality() + 1);

				// Si l'item est "Backstage ..."
				if (items.get(numItem).getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
					// Si le backstage sellin est inférieur à 11
					if (items.get(numItem).getSellIn() < 11) {
						// Si la qualité est ENCORE inférieur à 50
						if (items.get(numItem).getQuality() < 50) {
							items.get(numItem).setQuality(items.get(numItem).getQuality() + 1);
						}
					}

					// Si le sellin de "Backstage ..." est inf à 6
					if (items.get(numItem).getSellIn() < 6) {
						// Si la qualité est ENCORE inférieur à 50
						if (items.get(numItem).getQuality() < 50) {
							items.get(numItem).setQuality(items.get(numItem).getQuality() + 1);
						}
					}
				}
			}
		} else {
// Si sa qualité est supérieur à 0
if (items.get(numItem).getQuality() > 0) {
		// Si ce n'est pas Sulfuras
		if (!items.get(numItem).getName().equals("Sulfuras, Hand of Ragnaros")) {
			items.get(numItem).setQuality(items.get(numItem).getQuality() - 1);
		}
}
}

		this.updateItemSellin(numItem);

		// Si le sellin de l'item est inf à 0
		if (items.get(numItem).getSellIn() < 0) {
			// Si l'item n'est pas Aged Brie
			if (!items.get(numItem).getName().equals("Aged Brie")) {
				// Si l'item n'est pas Bakstage ...
				if (!items.get(numItem).getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
					// Si la qualité de l'item est sup à 0
					if (items.get(numItem).getQuality() > 0) {
						// Si l'item n'est pas Sulfuras
						if (!items.get(numItem).getName().equals("Sulfuras, Hand of Ragnaros")) {
							items.get(numItem).setQuality(items.get(numItem).getQuality() - 1);
						}
					}
				} else {
					// Si l'item est "Backstage ..."
					items.get(numItem).setQuality(0);
				}
				// Si l'item est Aged Brie
			} else {
				if (items.get(numItem).getQuality() < 50) {
					items.get(numItem).setQuality(items.get(numItem).getQuality() + 1);
				}
			}
		}
	}

	private void updateItemSellin(int numItem) {
		// Si l'item n'est pas Sulfuras
		if (!items.get(numItem).getName().equals("Sulfuras, Hand of Ragnaros")) {
			// On diminue son sellin de -1
			items.get(numItem).setSellIn(items.get(numItem).getSellIn() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println("OMGHAI!");
		new Inn().updateQuality();
	}
}