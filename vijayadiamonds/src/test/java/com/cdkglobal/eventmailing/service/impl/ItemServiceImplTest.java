package com.cdkglobal.eventmailing.service.impl;

import com.vijayadiamonds.model.Item;
import com.vijayadiamonds.repository.ItemRepository;
import com.vijayadiamonds.service.impl.ItemServiceImpl;
import junit.framework.Assert;
import org.apache.commons.lang.reflect.FieldUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

/**
 * Test the functionality of {@link ItemServiceImpl}
 *
 * @author Janardhan
 */
@RunWith(MockitoJUnitRunner.class)
public class ItemServiceImplTest {

    @Mock
    Item item;
    @Mock
    private ItemRepository itemRepository;

    @Test
    public void testGetItemById() throws IllegalAccessException {
        ItemServiceImpl service = new ItemServiceImpl();

        FieldUtils.writeField(service, "itemRepository", itemRepository, true);
        when(itemRepository.findOne(anyLong())).thenReturn(item);
        Item expected = itemRepository.findOne(1L);
        Assert.assertEquals(item, expected);
    }
}
