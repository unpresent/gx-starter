package ru.gx.core.channels;

import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.gx.core.messaging.*;

/**
 * Интерфейс описателя канала получения и обработки входящих данных.
 */
@Accessors(chain = true)
@SuppressWarnings("unused")
public abstract class AbstractOutcomeChannelHandleDescriptor<M extends Message<? extends MessageHeader, ? extends MessageBody>>
        extends AbstractChannelHandleDescriptor<M>
        implements OutcomeChannelHandleDescriptor<M> {
    // -----------------------------------------------------------------------------------------------------------------
    // <editor-fold desc="Fields">
    private final SimpleMetadataContainer metadataContainer;

    // </editor-fold>
    // -----------------------------------------------------------------------------------------------------------------
    // <editor-fold desc="Initialize">
    protected AbstractOutcomeChannelHandleDescriptor(
            @NotNull final ChannelsConfiguration owner,
            @NotNull ChannelApiDescriptor<M> api,
            @Nullable final OutcomeChannelDescriptorsDefaults defaults
    ) {
        super(owner, api, ChannelDirection.In, defaults);
        this.metadataContainer = new SimpleMetadataContainer();
    }
    // </editor-fold>
    // -----------------------------------------------------------------------------------------------------------------
    // <editor-fold desc="Implements MetadataGetter & MetadataSetter">
    @Override
    public int metadataSize() {
        return this.metadataContainer.metadataSize();
    }

    @Override
    public boolean containsMetadataKey(@NotNull final Object metadataKey) {
        return this.metadataContainer.containsMetadataKey(metadataKey);
    }

    @Override
    public @Nullable Object getMetadataValue(@NotNull final Object metadataKey) {
        return this.metadataContainer.getMetadataValue(metadataKey);
    }

    @Override
    public Iterable<Metadata> getAllMetadata() {
        return this.metadataContainer.getAllMetadata();
    }

    @Override
    public AbstractOutcomeChannelHandleDescriptor<M> putMetadata(@NotNull final Object key, @Nullable final Object value) {
        this.metadataContainer.putMetadata(key, value);
        return this;
    }

    @Override
    public AbstractOutcomeChannelHandleDescriptor<M> setMetadata(@Nullable Iterable<Metadata> source) {
        this.metadataContainer.setMetadata(source);
        return this;
    }
    // </editor-fold>
    // -----------------------------------------------------------------------------------------------------------------
}
